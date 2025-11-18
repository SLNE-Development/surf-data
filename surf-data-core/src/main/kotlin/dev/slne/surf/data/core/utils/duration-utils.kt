package dev.slne.surf.data.core.utils

import kotlin.time.Duration
import kotlin.time.toKotlinDuration

suspend inline fun <T> measureTimeReturning(block: suspend () -> T): Pair<T, Duration> {
    val start = System.nanoTime()
    val result = block()
    val end = System.nanoTime()
    val duration = java.time.Duration.ofNanos(end - start)

    return result to duration.toKotlinDuration()
}