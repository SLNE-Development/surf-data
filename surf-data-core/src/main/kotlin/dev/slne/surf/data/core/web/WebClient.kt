package dev.slne.surf.data.core.web

import dev.slne.surf.data.core.config.dataConfig
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.auth.*
import io.ktor.client.plugins.auth.providers.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

object WebClient {
    val webConfig get() = dataConfig.web

    fun create() = HttpClient(CIO) {
        engine { }

        Charsets {
            register(Charsets.UTF_8)
            sendCharset = Charsets.UTF_8
            responseCharsetFallback = Charsets.UTF_8
        }

        defaultRequest {
            val rawUrl = webConfig.host
            val url = if (rawUrl.endsWith("/")) rawUrl else "$rawUrl/"

            url(url)
        }

        install(Auth) {
            bearer {
                loadTokens {
                    BearerTokens(webConfig.bearerToken, webConfig.bearerToken)
                }
            }
        }

        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            })
        }

        install(HttpRequestRetry) {
            retryOnExceptionOrServerErrors(maxRetries = webConfig.maxRetries)
            exponentialDelay()
        }

        install(Logging) {
            logger = Logger.DEFAULT
            level = LogLevel.NONE
        }

        install(HttpTimeout) {
            requestTimeoutMillis = webConfig.requestTimeout
            connectTimeoutMillis = webConfig.connectionTimeout
            socketTimeoutMillis = webConfig.socketTimeout
        }

        install(UserAgent) {
            agent = "SurfDataClient/1.0"
        }

//        expectSuccess = true
        followRedirects = true
    }
}