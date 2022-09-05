package com.chutneytesting.hello

import com.chutneytesting.kotlin.launcher.Launcher
import org.junit.jupiter.api.Test

class RunHelloTests {

    @Test
    fun `search title is displayed`() {
        Launcher("target/chutney/reports").run(search_title_scenario, environment_fr)
    }
}
