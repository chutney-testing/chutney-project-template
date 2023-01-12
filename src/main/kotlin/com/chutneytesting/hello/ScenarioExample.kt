package com.chutneytesting.hello

import com.chutneytesting.kotlin.dsl.*

val call_google = Scenario(id = 13, title = "Call google") {
    Given("Create variable") {
        ContextPutAction(
            entries = mapOf(
                "name" to "Chutney"
            )
        )
    }
    And("Some http call") {
        HttpGetAction(
            target = "google",
            uri = "/"
        )
    }
    When("Hello world") {
        SuccessAction()
    }
    Then("Stupid assert") {
        StringAssertAction(
            document = "name".spEL,
            expected = "Chutney"
        )
    }
}

val call_a_website = Scenario(title = "Call a website") {
    When("Hello website") {
        HttpGetAction(
            target = "website",
            uri = "/",
            validations = mapOf("http 200" to "status == 200".spEL())
        )
    }
    Then("Stupid assert") {
        SuccessAction()
    }
}

val should_fail = Scenario(id = 37, title = "Call unknown and fail") {
    When("Hello unknown") {
        HttpGetAction(
            target = "unknown",
            uri = "/"
        )
    }
    Then("Fail") {
        AssertAction(listOf("status == 200".spEL))
    }
    And("Should not be executed") {
        SuccessAction()
    }
}

fun alwaysSuccessWithParam(param: String) = Scenario(title = "Always success with $param") {
    When("Just ok") {
        SuccessAction()
    }
}

// The following is a test suite used for syncing a list of scenarios with an on premise Chutney Server
val test_suite = listOf(
    call_google,
    should_fail
)
