package dev.slne.surf.data.core.config

import kotlinx.serialization.Serializable
import org.springframework.beans.factory.annotation.Configurable

@Configurable
@Serializable
data class WebConfig(
    val host: String,
    val bearerToken: String
)