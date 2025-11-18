plugins {
    id("dev.slne.surf.surfapi.gradle.core")
}

dependencies {
    api("org.springframework.boot:spring-boot-starter-web")
    api("org.springframework.boot:spring-boot-starter-data-redis")
    api("org.springframework.boot:spring-boot-starter-data-redis-reactive")
    api(libs.bundles.ktor.client)
}