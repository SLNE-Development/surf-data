package dev.slne.surf.data.core.config

import dev.slne.surf.data.core.context.DataContext
import dev.slne.surf.surfapi.core.api.config.createSpongeYmlConfig
import dev.slne.surf.surfapi.core.api.config.surfConfigApi
import kotlinx.serialization.Serializable
import org.springframework.beans.factory.annotation.Configurable

@Configurable
@Serializable
data class DataConfig(
    val redis: RedisConfig,
    val web: WebConfig
)

val dataConfig by lazy {
    surfConfigApi.createSpongeYmlConfig<DataConfig>(DataContext.dataPath, "connection-config.yml")
}