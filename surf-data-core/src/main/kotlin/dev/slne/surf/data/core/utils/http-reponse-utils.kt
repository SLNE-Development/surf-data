package dev.slne.surf.data.core.utils

import io.ktor.client.statement.*
import io.ktor.http.*

suspend inline fun HttpResponse.onStatus(
    statusCode: HttpStatusCode,
    block: suspend HttpResponse.() -> HttpResponse
): HttpResponse = when (status) {
    statusCode -> block()
    else -> this
}

fun HttpResponse.requireSuccess() = when {
    !status.isSuccess() -> throw IllegalStateException("Request failed with status code: $status")
    else -> this
}