package dev.slne.surf.data.core.configuration

import dev.slne.surf.data.core.config.dataConfig
import io.netty.channel.ChannelOption
import io.netty.handler.timeout.ReadTimeoutHandler
import io.netty.handler.timeout.WriteTimeoutHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.http.CacheControl
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.http.client.ReactorResourceFactory
import org.springframework.http.client.reactive.ReactorClientHttpConnector
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.support.WebClientAdapter
import org.springframework.web.service.invoker.HttpServiceProxyFactory
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.toJavaDuration

@Configuration
class DataWebClientConfiguration {
    @Bean
    fun resourceFactory() = ReactorResourceFactory().apply {
        isUseGlobalResources = false
    }

    @Bean
    fun webClientUrl(): String {
        val configUrl = dataConfig.web.host

        return if (configUrl.endsWith("/")) {
            configUrl
        } else {
            "$configUrl/"
        }
    }

    @Bean
    @Primary
    fun webClient() = WebClient.builder().baseUrl(webClientUrl())
        .defaultHeaders { headers ->
            headers.set("Authorization", "Bearer ${dataConfig.web.bearerToken}")
            headers.set("User-Agent", "SurfDiscordBot/1.0")
            headers.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)

            headers.setCacheControl(CacheControl.noCache())
        }
        .codecs { configurer ->
            configurer.defaultCodecs().maxInMemorySize(16 * 1024 * 1024)
        }
        .clientConnector(ReactorClientHttpConnector(resourceFactory()) { client ->
            client.option(ChannelOption.CONNECT_TIMEOUT_MILLIS, dataConfig.web.connectionTimeout)
            client.responseTimeout(dataConfig.web.responseTimeout.milliseconds.toJavaDuration())
            client.doOnConnected { connection ->
                connection.addHandlerLast(ReadTimeoutHandler(dataConfig.web.readTimeout))
                connection.addHandlerLast(WriteTimeoutHandler(dataConfig.web.writeTimeout))
            }
        })
        .build()


    @Bean
    fun webClientFactory(webClient: WebClient): HttpServiceProxyFactory {
        val adapter = WebClientAdapter.create(webClient)
        return HttpServiceProxyFactory.builderFor(adapter).build()
    }
}