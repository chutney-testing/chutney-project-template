package com.chutneytesting.hello

import com.chutneytesting.kotlin.dsl.ChutneyEnvironment
import com.chutneytesting.kotlin.dsl.ChutneyTarget

val chutney = ChutneyTarget(
    name = "chutney",
    url = "https://www.chutney-testing.com"
)

val en_search_engine = ChutneyTarget(
    name = "search_engine", // dependency based on this string
    url = "https://www.google.com"
)

val unknown = ChutneyTarget(
    name = "unknown", // dependency based on this string
    url = "http://un.known.unknown"
)

val english_web = ChutneyEnvironment(
    name = "english_web",
    description = "fake environment for test",
    targets = listOf(
        chutney,
        en_search_engine,
        unknown
    )
)

val chutney_source = chutney.copy(url = "https://github.com/chutney-testing")
val fr_search_engine = en_search_engine.copy(url = "https://www.google.fr")

val french_web = ChutneyEnvironment(
    name = "french_web",
    description = "fake environment for test",
    targets = listOf(
        chutney_source,
        fr_search_engine
    )
)
