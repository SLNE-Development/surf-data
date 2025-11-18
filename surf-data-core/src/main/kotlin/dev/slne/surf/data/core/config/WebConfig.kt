package dev.slne.surf.data.core.config

import org.apache.commons.lang3.RandomStringUtils
import org.spongepowered.configurate.objectmapping.ConfigSerializable
import org.spongepowered.configurate.objectmapping.meta.Comment

@ConfigSerializable
data class WebConfig(
    val host: String = "localhost",
    val bearerToken: String = RandomStringUtils.secureStrong().nextAlphanumeric(128),

    @param:Comment("Connection timeout in milliseconds")
    val connectionTimeout: Long = 500,

    @param:Comment("Request timeout in milliseconds")
    val requestTimeout: Long = 1500,

    @param:Comment("Socket timeout in milliseconds")
    val socketTimeout: Long = 1500,

    @param:Comment("Maximum number of retries for failed requests")
    val maxRetries: Int = 3,
)