plugins {
    application
    kotlin("jvm") version "1.4.10"
    id("info.solidsoft.pitest") version "1.5.2"
}

group = "fr.xebia.sdecout.advent"
version = "1.0.0"

val junit_version = "5.3.1"
val archunit_version = "0.14.1"
val arrow_version = "0.11.0"

dependencies {
    implementation(kotlin("stdlib"))
    implementation("io.arrow-kt", "arrow-core", arrow_version)
    testImplementation(kotlin("test-junit5"))
    testImplementation("org.junit.jupiter", "junit-jupiter-api", junit_version)
    testImplementation("org.junit.jupiter", "junit-jupiter-params", junit_version)
    testRuntimeOnly("org.junit.jupiter", "junit-jupiter-engine", junit_version)
    testImplementation("org.assertj", "assertj-core", "3.16.1")
    testImplementation("com.tngtech.archunit", "archunit-junit5-api", archunit_version)
    testImplementation("com.tngtech.archunit", "archunit-junit5-engine", archunit_version)
}

tasks {
    compileKotlin {
        kotlinOptions {
            jvmTarget = "11"
        }
    }
    test {
        useJUnitPlatform()
    }
    pitest {
        junit5PluginVersion.set("0.12")
        outputFormats.add("HTML")
        excludedGroups.add("Integration")
        targetClasses.set(listOf(
            "fr.xebia.sdecout.common.*",
            "fr.xebia.sdecout.mowitnow.core.*"
        ))
    }
}

repositories {
    mavenCentral()
}
