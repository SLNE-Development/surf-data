package dev.slne.surf.data.core.configuration.feign.logger

import feign.Response
import feign.codec.ErrorDecoder
import net.kyori.adventure.text.logger.slf4j.ComponentLogger
import org.springframework.stereotype.Component

@Component
class FeignErrorDecoder : ErrorDecoder {
    private val logger = FeignLogger(ComponentLogger.logger("WebApi"))

    override fun decode(
        methodKey: String,
        response: Response
    ): Exception? {
        val body = response.body()
            ?.asInputStream()
            ?.bufferedReader()
            .use { it?.readText() }

        logger.error("Error during Feign call:")
        logger.error("Method: $methodKey")
        logger.error("Status: ${response.status()}")
        logger.error("Body: $body")

        return Exception("Feign call failed with status ${response.status()}: $body")
    }
}