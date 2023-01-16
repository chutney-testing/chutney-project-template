package com.chutneytesting.hello

import com.chutneytesting.kotlin.synchronize.synchronise
import com.chutneytesting.kotlin.util.ChutneyServerInfo

val chutneyLocalServer = ChutneyServerInfo(
    remoteServerUrl = "https://localhost:8081", remoteUserName = "admin", remoteUserPassword = "admin"
)

fun main() {
    test_suite.forEach { it.synchronise(serverInfo = chutneyLocalServer, updateRemote = true) }
}
