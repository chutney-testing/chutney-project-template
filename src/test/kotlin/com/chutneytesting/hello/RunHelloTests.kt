package com.chutneytesting.hello

import com.chutneytesting.kotlin.dsl.ChutneyScenario
import com.chutneytesting.kotlin.junit.api.ChutneyTest
import com.chutneytesting.kotlin.launcher.Launcher
import org.junit.jupiter.api.Test

class RunHelloTests {

    @ChutneyTest(environment = "environment_en")
    fun testMethod(): ChutneyScenario {
        return search_title_scenario
    }

    @Test
    fun `search title is displayed`() {
        Launcher().run(search_title_scenario, environment_fr)
    }

}
