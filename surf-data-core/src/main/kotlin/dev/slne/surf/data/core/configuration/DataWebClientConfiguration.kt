package dev.slne.surf.data.core.configuration

import dev.slne.surf.data.core.context.getBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.CacheControl
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.support.WebClientAdapter
import org.springframework.web.service.invoker.HttpServiceProxyFactory

@Configuration
class DataWebClientConfiguration {
    @Bean
    fun webClient() = WebClient.builder().baseUrl("https://api.castcrafter.de/v1")
        .defaultHeaders { headers ->
            headers.set("Authorization", "Bearer abcd")
            headers.set("User-Agent", "SurfDiscordBot/1.0")
            headers.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)

            headers.setCacheControl(CacheControl.noCache())
        }
        .codecs { configurer ->
            configurer.defaultCodecs().maxInMemorySize(16 * 1024 * 1024)
        }
        .build()

    @Bean
    fun webClientAdapter(webClient: WebClient) =
        WebClientAdapter.create(webClient)

    @Bean
    fun webClientFactory(adapter: WebClientAdapter) =
        HttpServiceProxyFactory.builderFor(adapter).build()

    @Bean
    fun webClientFactory() = getBean<HttpServiceProxyFactory>()
}

inline fun <reified T : Any> HttpServiceProxyFactory.createClient() =
    this.createClient(T::class.java)