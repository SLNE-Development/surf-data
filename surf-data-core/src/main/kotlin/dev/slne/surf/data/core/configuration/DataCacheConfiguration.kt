package dev.slne.surf.data.core.configuration

import com.github.benmanes.caffeine.cache.Caffeine
import org.springframework.cache.caffeine.CaffeineCacheManager
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import kotlin.time.Duration.Companion.minutes
import kotlin.time.toJavaDuration

@Configuration
class DataCacheConfiguration {
    @Bean
    fun caffeineConfig() =
        Caffeine.newBuilder().expireAfterWrite(60.minutes.toJavaDuration())

    @Bean
    fun cacheManager(caffeine: Caffeine<Any, Any>) = CaffeineCacheManager().apply {
        this.setCaffeine(caffeine)
    }
}