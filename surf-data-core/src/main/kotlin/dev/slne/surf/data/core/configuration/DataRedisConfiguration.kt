package dev.slne.surf.data.core.configuration

import dev.slne.surf.data.core.config.dataConfig
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.RedisPassword
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory
import org.springframework.data.redis.core.RedisTemplate

@Configuration
class DataRedisConfiguration {
    @Bean
    fun connectionFactory() = LettuceConnectionFactory().apply {
        with(standaloneConfiguration) {
            hostName = dataConfig.redis.host
            port = dataConfig.redis.port
            
            if (dataConfig.redis.password?.isNotEmpty() ?: false) {
                password = RedisPassword.of(dataConfig.redis.password)
            }

            database = dataConfig.redis.database
        }
    }

    @Bean
    fun redisTemplate(
        connectionFactory: LettuceConnectionFactory
    ) = RedisTemplate<String, String>().apply {
        this.connectionFactory = connectionFactory
    }
}