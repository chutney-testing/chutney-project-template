package com.chutneytesting.hello

import com.chutneytesting.kotlin.dsl.*

// An id is required when you want to sync the scenario with an on premise Chutney Server
val call_search_engine = Scenario(id = 13, title = "Call a search engine") {
    When("Calling a famous search engine") {
        HttpGetAction(
            target = "search_engine",
            uri = "/"
        )
    }
    Then("It should always be running") {
        AssertAction(listOf("status == 200".spEL))
    }
}

val call_a_chutney_website = Scenario(title = "Call a Chutney website") {
    When("Hello website") {
        HttpGetAction(
            target = "chutney",
            uri = "/",
            validations = mapOf("Chutney says Hello" to "status == 200".spEL())
        )
    }
}

// An id is required when you want to sync the scenario with an on premise Chutney Server
val should_fail = Scenario(id = 37, title = "Call unknown and fail") {
    When("Hello unknown") {
        HttpGetAction(
            target = "unknown",
            uri = "/",
            validations = mapOf("server says Hello" to "status == 200".spEL())
        )
    }
    Then("This step should not be executed") {
        SuccessAction()
    }
}

fun alwaysSuccessWithParam(param: String) = Scenario(title = "Scenario succeed for the $param time") {
    When("Just ok") {
        SuccessAction()
    }
}

// The following is a test suite used for syncing a list of scenarios with an on premise Chutney Server
val test_suite = listOf(
    call_search_engine,
    should_fail
)
