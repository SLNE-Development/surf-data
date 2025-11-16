package dev.slne.surf.data.core.config

import dev.slne.surf.data.core.context.DataContext
import dev.slne.surf.surfapi.core.api.config.createSpongeYmlConfig
import dev.slne.surf.surfapi.core.api.config.surfConfigApi
import kotlinx.serialization.Serializable
import org.spongepowered.configurate.objectmapping.ConfigSerializable
import org.springframework.beans.factory.annotation.Configurable

@ConfigSerializable
data class DataConfig(
    val redis: RedisConfig = RedisConfig(),
    val web: WebConfig = WebConfig()
)

val dataConfig by lazy {
    surfConfigApi.createSpongeYmlConfig<DataConfig>(DataContext.dataPath, "connection-config.yml")
}