import com.github.jengelman.gradle.plugins.shadow.relocation.SimpleRelocator
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
        exclude(group = "io.projectreactor.netty", module = "reactor-netty")
        exclude(group = "io.netty", module = "netty-all")
    }

    tasks.withType<ShadowJar> {
        duplicatesStrategy = DuplicatesStrategy.EXCLUDE
        mergeServiceFiles()

        exclude("kotlin/**")
        exclude("reactor/**")
        exclude("org/reactivestreams/**")
        exclude("io/netty/**")

        val relocations = mapOf<String, (SimpleRelocator) -> Unit>(
//            "io.netty" to {
//                it.exclude("META-INF/native/**")
//                it.exclude("**/*.dll")
//                it.exclude("**/*.so")
//                it.exclude("**/*.dylib")
//            },
            "ch.qos.logback" to { },
            "com.fasterxml" to { },
            "com.jayway" to { },
            "io.lettuce" to { },
            "io.micrometer" to { },
            "jakarta" to { },
            "net.minidev" to { },
            "org.aopalliance" to { },
            "org.apache" to { },
            "org.atteo" to { },
            "org.bouncycastle" to { },
            "org.intellij" to { },
            "org.jetbrains" to { },
            "org.jspecify" to { },
            "org.objectweb" to { },
            "org.slf4j" to { },
            "org.yaml" to { },
            "redis.clients" to { },
            "tools.jackson" to { },
        )

        relocations.forEach { (prefix, configure) ->
            relocate(prefix, "dev.slne.surf.data.shadow.$prefix", configure)
        }
    }

    repositories {
        maven { url = uri("https://repo.spring.io/snapshot") }
    }
}