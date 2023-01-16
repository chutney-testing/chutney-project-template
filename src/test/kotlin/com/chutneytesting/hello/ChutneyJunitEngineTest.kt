package com.chutneytesting.hello

import com.chutneytesting.kotlin.dsl.ChutneyScenario
import com.chutneytesting.kotlin.junit.api.ChutneyTest

class ChutneyJunitEngineTest {

    companion object {
        @JvmField
        val ENV_AS_FIELD = french_web
    }

    // Use a companion object to pass an environment definition from a val in com.chutneytesting.hello.Environments.english_web
    @ChutneyTest(environment = "ENV_AS_FIELD")
    fun `call a chutney website from french web using a jvm field`(): ChutneyScenario {
        return call_a_chutney_website
    }

    // Takes environment definition from environment_path/CHUTNEY.json, set by system property 'chutney.environment.rootPath'
    @ChutneyTest(environment = "english_web")
    fun `call a chutney website from english web`(): ChutneyScenario {
        return call_a_chutney_website
    }

    // Takes environment definition from environment_path/CHUTNEY.json, set by system property 'chutney.environment.rootPath'
    @ChutneyTest(environment = "french_web")
    fun `run a scenario 3 times using a different param for each execution`(): List<ChutneyScenario> {
        return listOf("FIRST", "SECOND", "THIRD").map {
            alwaysSuccessWithParam(it)
        }
    }
}
