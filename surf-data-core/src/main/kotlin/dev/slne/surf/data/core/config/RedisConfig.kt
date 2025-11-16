package dev.slne.surf.data.core.config

import kotlinx.serialization.Serializable
import org.spongepowered.configurate.objectmapping.ConfigSerializable

@ConfigSerializable
data class RedisConfig(
    val host: String = "localhost",
    val port: Int = 6379,
    val password: String? = null,
)