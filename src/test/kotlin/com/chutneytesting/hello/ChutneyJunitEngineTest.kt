package com.chutneytesting.hello

import com.chutneytesting.kotlin.dsl.ChutneyScenario
import com.chutneytesting.kotlin.junit.api.ChutneyTest

class ChutneyJunitEngineTest {

    companion object {
        @JvmField
        val ENV_AS_FIELD = GOOGLE
    }

    // Use a companion object to pass an environment definition from a val in com.chutneytesting.hello.Environments.GOOGLE
    @ChutneyTest(environment = "ENV_AS_FIELD")
    fun testMethodWithEnvField(): ChutneyScenario {
        return call_a_website
    }

    // Takes environment definition from environment_path/CHUTNEY.json, set by system property 'chutney.environment.rootPath'
    @ChutneyTest(environment = "GOOGLE")
    fun testMethod(): ChutneyScenario {
        return call_a_website
    }

    // Takes environment definition from environment_path/CHUTNEY.json, set by system property 'chutney.environment.rootPath'
    @ChutneyTest(environment = "CHUTNEY")
    fun testMethodWithScenarioList(): List<ChutneyScenario> {
        return listOf("first", "second", "third").map {
            alwaysSuccessWithParam(it)
        }
    }
}
