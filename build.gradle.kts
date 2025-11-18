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

    tasks.withType<ShadowJar> {
        duplicatesStrategy = DuplicatesStrategy.EXCLUDE
        mergeServiceFiles()

        exclude("kotlin/**")
        exclude("kotlinx/**")
//        exclude("io/netty/**")
        exclude("reactor/**")
        exclude("org/reactivestreams/**")

        relocate("io.ktor", "dev.slne.surf.data.shadow.ktor")
    }

    repositories {
        maven { url = uri("https://repo.spring.io/snapshot") }
    }
    
    springBoot {
        mainClass.set("ignore")
    }
}