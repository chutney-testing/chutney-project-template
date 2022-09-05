package com.chutneytesting.hello

import com.chutneytesting.kotlin.synchronize.synchronise
import com.chutneytesting.kotlin.util.ChutneyServerInfo

val chutneyLocalServer = ChutneyServerInfo(
    remoteServerUrl = "http://localhost:8081", remoteUserName = "admin", remoteUserPassword = "admin"
)

fun main() {
    hello_campaign.forEach { it.synchronise(serverInfo = chutneyLocalServer, updateRemote = true) }
}
