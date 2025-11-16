pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
        maven { url = uri("https://repo.spring.io/snapshot") }
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}

rootProject.name = "surf-data"

include("surf-data-core")
include("surf-data-paper")
include("surf-data-velocity")

include("surf-data-test:surf-data-test-paper")
include("surf-data-test:surf-data-test-velocity")