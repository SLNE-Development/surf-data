package dev.slne.surf.data.core.config

import org.apache.commons.lang3.RandomStringUtils
import org.spongepowered.configurate.objectmapping.ConfigSerializable
import org.spongepowered.configurate.objectmapping.meta.Comment

@ConfigSerializable
data class WebConfig(
    val host: String = "localhost",
    val bearerToken: String = RandomStringUtils.secureStrong().nextAlphanumeric(128),

    @param:Comment("Timeout in milliseconds for establishing a connection")
    val connectionTimeout: Int = 500,

    @param:Comment("Timeout in milliseconds for reading data")
    val readTimeout: Int = 1500,

    @param:Comment("Timeout in milliseconds for writing data")
    val writeTimeout: Int = 1500,

    @param:Comment("Timeout in milliseconds for receiving a response")
    val responseTimeout: Int = 3000,

    @param:Comment("Number of retries for failed requests")
    val maxRetries: Int = 3,
)