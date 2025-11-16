package dev.slne.surf.data.core.utils

import dev.slne.surf.data.core.context.getBean
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.client.WebClient

object DefaultHttpClient {
    val client get() = getBean<WebClient>()

    fun get(
        uri: String,
        vararg args: Any,
        headerConsumer: (HttpHeaders) -> Unit = {},
        accept: MediaType = MediaType.APPLICATION_JSON,
    ) = client
        .get()
        .uri(uri, *args)
        .headers(headerConsumer)
        .accept(accept)
        .retrieve()

    fun post(
        uri: String,
        vararg args: Any,
        headerConsumer: (HttpHeaders) -> Unit = {},
        accept: MediaType = MediaType.APPLICATION_JSON,
    ) = client
        .post()
        .uri(uri, *args)
        .headers(headerConsumer)
        .accept(accept)
        .retrieve()

    fun delete(
        uri: String,
        vararg args: Any,
        headerConsumer: (HttpHeaders) -> Unit = {},
        accept: MediaType = MediaType.APPLICATION_JSON,
    ) = client
        .delete()
        .uri(uri, *args)
        .headers(headerConsumer)
        .accept(accept)
        .retrieve()

    fun put(
        uri: String,
        vararg args: Any,
        headerConsumer: (HttpHeaders) -> Unit = {},
        accept: MediaType = MediaType.APPLICATION_JSON,
    ) = client
        .put()
        .uri(uri, *args)
        .headers(headerConsumer)
        .accept(accept)
        .retrieve()

    fun patch(
        uri: String,
        vararg args: Any,
        headerConsumer: (HttpHeaders) -> Unit = {},
        accept: MediaType = MediaType.APPLICATION_JSON,
    ) = client
        .patch()
        .uri(uri, *args)
        .headers(headerConsumer)
        .accept(accept)
        .retrieve()

    fun head(
        uri: String,
        vararg args: Any,
        headerConsumer: (HttpHeaders) -> Unit = {},
        accept: MediaType = MediaType.APPLICATION_JSON,
    ) = client
        .head()
        .uri(uri, *args)
        .headers(headerConsumer)
        .accept(accept)
        .retrieve()

    fun options(
        uri: String,
        vararg args: Any,
        headerConsumer: (HttpHeaders) -> Unit = {},
        accept: MediaType = MediaType.APPLICATION_JSON,
    ) = client
        .options()
        .uri(uri, *args)
        .headers(headerConsumer)
        .accept(accept)
        .retrieve()
}

