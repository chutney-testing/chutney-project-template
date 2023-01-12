package com.chutneytesting.hello

import com.chutneytesting.kotlin.dsl.ChutneyEnvironment
import com.chutneytesting.kotlin.dsl.ChutneyTarget

val unknown = ChutneyTarget(
    name = "unknown", // dependency based on this string
    url = "http://un.known.unknown"
)

val google = ChutneyTarget(
    name = "website", // dependency based on this string
    url = "https://www.google.fr"
)

val googel = google.copy(name = "google")

val GOOGLE = ChutneyEnvironment(
    name = "GOOGLE",
    description = "fake environment for test",
    targets = listOf(
        google,
        googel,
        unknown
    )
)

////////

val chutney = ChutneyTarget(
    name = "website",
    url = "https://www.chutney-testing.com"
)

val CHUTNEY = ChutneyEnvironment(
    name = "CHUTNEY",
    description = "fake environment for test",
    targets = listOf(
        chutney,
        googel
    )
)
