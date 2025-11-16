package dev.slne.surf.data.core.config

import kotlinx.serialization.Serializable
import org.spongepowered.configurate.objectmapping.meta.Comment
import org.springframework.beans.factory.annotation.Configurable

@Configurable
@Serializable
data class WebConfig(
    val host: String,
    val bearerToken: String,

    @param:Comment("Timeout in milliseconds for establishing a connection")
    val connectionTimeout: Int,

    @param:Comment("Timeout in milliseconds for reading data")
    val readTimeout: Int,

    @param:Comment("Timeout in milliseconds for writing data")
    val writeTimeout: Int,

    @param:Comment("Timeout in milliseconds for receiving a response")
    val responseTimeout: Int,

    @param:Comment("Number of retries for failed requests")
    val maxRetries: Int,
)