package com.chutneytesting.hello

import com.chutneytesting.kotlin.dsl.ChutneyEnvironment
import com.chutneytesting.kotlin.launcher.Launcher
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class RunHelloMultipleEnvironmentTests {

    private companion object {
        @JvmStatic
        fun environments() = Stream.of(
            Arguments.of(environment_fr),
            Arguments.of(environment_en)
        )
    }

    @ParameterizedTest
    @MethodSource("environments")
    fun `scenario on multiple environment`(environment: ChutneyEnvironment) {
        Launcher("target/chutney/reports").run(search_title_scenario, environment)
    }
}
