package dev.slne.surf.data.core.config

import kotlinx.serialization.Serializable
import org.springframework.beans.factory.annotation.Configurable

@Configurable
@Serializable
data class RedisConfig(
    val host: String,
    val port: Int,
    val password: String?,
)