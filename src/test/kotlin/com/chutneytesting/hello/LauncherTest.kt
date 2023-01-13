package com.chutneytesting.hello

import com.chutneytesting.engine.api.execution.StatusDto.FAILURE
import com.chutneytesting.kotlin.dsl.ChutneyEnvironment
import com.chutneytesting.kotlin.dsl.ChutneyScenario
import com.chutneytesting.kotlin.launcher.Launcher
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class LauncherTest : ParameterizedMethods() {

    private val launcher = Launcher()

    @ParameterizedTest
    @MethodSource("environments")
    fun `is able to run a scenario on different environments`(environment: ChutneyEnvironment) {
        launcher.run(call_a_chutney_website, environment)
    }

    @ParameterizedTest
    @MethodSource("campaign")
    fun `is able to run a test suite on one environment`(scenario: ChutneyScenario) {
        launcher.run(scenario, english_web)
    }

    private val test_suite = listOf(
        call_search_engine,
        call_a_chutney_website
    )

    @ParameterizedTest
    @MethodSource("environments_by_names")
    fun `is able to run a test suite on many environments using their names`(environmentName: String) {
        launcher.run(test_suite, environmentName)
    }

    @Test
    fun `is able to fail`() {
        launcher.run(should_fail, english_web, FAILURE)
    }
}
