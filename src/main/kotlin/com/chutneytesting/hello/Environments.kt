package com.chutneytesting.hello

import com.chutneytesting.kotlin.dsl.ChutneyEnvironment
import com.chutneytesting.kotlin.dsl.ChutneyTarget

val google_fr = ChutneyTarget(name = "search_engine", url = "https://www.google.fr")

val environment_fr = ChutneyEnvironment(
    name = "The French World Wide Web",
    description = "The World Wide Web, for strange but beautiful French people",
    targets = listOf(
        google_fr
    )
)
