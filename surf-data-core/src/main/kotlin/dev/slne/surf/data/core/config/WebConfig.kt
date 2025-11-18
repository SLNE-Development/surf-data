package dev.slne.surf.data.core.config

import org.apache.commons.lang3.RandomStringUtils
import org.spongepowered.configurate.objectmapping.ConfigSerializable
import org.spongepowered.configurate.objectmapping.meta.Comment

@ConfigSerializable
data class WebConfig(
    val host: String = "localhost",
    val bearerToken: String = RandomStringUtils.secureStrong().nextAlphanumeric(128),

    @param:Comment("Timeout in milliseconds for establishing a connection")
    val connectionTimeout: Long = 500,

    @param:Comment("Timeout in milliseconds for reading data")
    val readTimeout: Long = 1500,
)