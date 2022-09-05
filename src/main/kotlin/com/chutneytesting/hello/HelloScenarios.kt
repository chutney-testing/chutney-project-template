package com.chutneytesting.hello

import com.chutneytesting.kotlin.dsl.AssertTask
import com.chutneytesting.kotlin.dsl.HttpGetTask
import com.chutneytesting.kotlin.dsl.Scenario
import com.chutneytesting.kotlin.dsl.spEL

val search_title_scenario = Scenario(id = 1, title = "Search title displays") {
    When("I visit a search engine") {
        HttpGetTask(
            target = "search_engine",
            uri = "/",
            validations = mapOf("request accepted" to "status == 200".spEL()),
            outputs = mapOf("body" to "body".spEL())
        )
    }
    Then("The search engine title is displayed") {
        AssertTask(
            listOf(
                "body.contains('<title>Google</title>')".spEL()
            )
        )
    }
}

val hello_campaign = listOf(
    search_title_scenario
)
