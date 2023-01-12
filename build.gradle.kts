import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

group = "com.chutneytesting"
version = "0.1.0-SNAPSHOT"
description = "A GitHub project template to help you start with Chutney Kotlin DSL"

plugins {
    kotlin("jvm") version "1.6.21" apply true
}

repositories {
    mavenCentral()
}

dependencies {
    api("org.jetbrains.kotlin:kotlin-stdlib:1.6.21")
    api("com.chutneytesting:chutney-kotlin-dsl:[1.0.0,)")
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.2")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "11"
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

tasks.withType<Test> {
    useJUnitPlatform()
}

task("chutneyReportSite", JavaExec::class) {
    classpath(configurations.runtimeClasspath)

    mainClass.set("com.chutneytesting.kotlin.execution.report.SiteGeneratorMain")
    args("build/reports/chutney")
}

tasks {
    test {
        systemProperty("chutney.environment.rootPath", "chutney_environments") // Default is .chutney/environments
        systemProperty("chutney.report.rootPath", "build/reports/chutney")
        systemProperty("chutney.engine.stepAsTest", false)
        systemProperty("chutney.log.color.enabled", true)

        finalizedBy("chutneyReportSite")
    }
}

