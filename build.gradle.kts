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
    id("org.springframework.boot") version "3.5.7"
    id("io.spring.dependency-management") version "1.1.7"
}

allprojects {
    group = "dev.slne.surf.data"
    version = findProperty("version") as String

    apply(plugin = "io.spring.dependency-management")
    apply(plugin = "org.springframework.boot")

    ext {
        set("springCloudVersion", "2023.0.6")
    }

    dependencyManagement {
        imports {
            mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
        }
    }

    tasks.withType<ShadowJar> {
        duplicatesStrategy = DuplicatesStrategy.EXCLUDE
        mergeServiceFiles()

        exclude("kotlin/**")
        exclude("kotlinx/**")
        exclude("io/netty/**")
        exclude("reactor/**")
        exclude("org/reactivestreams/**")
    }

    repositories {
        maven { url = uri("https://repo.spring.io/snapshot") }
    }
}