package dev.slne.surf.data.core.feign

import dev.slne.surf.data.core.config.dataConfig
import feign.Feign

object FeignClientFactory {
    fun <T> create(clientClass: Class<T>): T = Feign.builder()
        .target(clientClass, dataConfig.web.host)
        ?: error("Missing feign client")

}

inline fun <reified T> FeignClientFactory.create() = create(T::class.java)
