plugins {
    id("dev.slne.surf.surfapi.gradle.core")
}

dependencies {
    api("org.springframework.boot:spring-boot-starter-data-redis")
    api("org.springframework.boot:spring-boot-starter-data-redis-reactive")
    api("org.springframework.boot:spring-boot-starter-data-rest")
    api("org.springframework.boot:spring-boot-starter-restclient")
    api("org.springframework.boot:spring-boot-starter-webclient")
    api("org.springframework.boot:spring-boot-starter-webflux")
    api("org.springframework.boot:spring-boot-starter-webmvc")
    api("com.fasterxml.jackson.module:jackson-module-kotlin")

    api("tools.jackson.module:jackson-module-kotlin")
}