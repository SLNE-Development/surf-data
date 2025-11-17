import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

buildscript {
    repositories {
        gradlePluginPortal()
        maven("https://repo.slne.dev/repository/maven-public/") { name = "maven-public" }
        maven { url = uri("https://repo.spring.io/snapshot") }
    }
    dependencies {
        classpath("dev.slne.surf:surf-api-gradle-plugin:1.21.10+")
    }
}

plugins {
    id("org.springframework.boot") version "4.0.0-SNAPSHOT"
    id("io.spring.dependency-management") version "1.1.7"
}

allprojects {
    group = "dev.slne.surf.data"
    version = findProperty("version") as String

    apply(plugin = "io.spring.dependency-management")
    apply(plugin = "org.springframework.boot")

    configurations.all {
        exclude(group = "org.jetbrains.kotlinx", module = "kotlinx-coroutines-reactor")
        exclude(group = "org.jetbrains.kotlinx", module = "kotlinx-coroutines-reactive")
        exclude(group = "org.reactivestreams", module = "reactive-streams")
    }

    tasks.withType<ShadowJar> {
        duplicatesStrategy = DuplicatesStrategy.EXCLUDE

        exclude("kotlin/**")
    }

    repositories {
        maven { url = uri("https://repo.spring.io/snapshot") }
    }
}