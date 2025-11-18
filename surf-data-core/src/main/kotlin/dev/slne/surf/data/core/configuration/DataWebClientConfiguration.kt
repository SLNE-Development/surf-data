package dev.slne.surf.data.core.configuration

import com.fasterxml.jackson.databind.ObjectMapper
import dev.slne.surf.data.core.config.dataConfig
import dev.slne.surf.data.core.configuration.feign.coder.SurfDecoder
import dev.slne.surf.data.core.configuration.feign.coder.SurfEncoder
import dev.slne.surf.data.core.configuration.feign.interceptor.FeignAuthenticationInterceptor
import dev.slne.surf.data.core.configuration.feign.logger.FeignErrorDecoder
import dev.slne.surf.data.core.configuration.feign.logger.FeignLogger
import feign.Request
import net.kyori.adventure.text.logger.slf4j.ComponentLogger
import org.springframework.beans.factory.ObjectProvider
import org.springframework.boot.autoconfigure.ImportAutoConfiguration
import org.springframework.cloud.openfeign.FeignAutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import
import java.util.concurrent.TimeUnit

@Configuration
@Import(FeignAuthenticationInterceptor::class, FeignErrorDecoder::class)
@ImportAutoConfiguration(FeignAutoConfiguration::class)
class DataWebClientConfiguration {
    @Bean
    fun decoder(
        objectMapper: ObjectProvider<ObjectMapper>
    ) = SurfDecoder(objectMapper)

    @Bean
    fun encoder(
        objectMapper: ObjectProvider<ObjectMapper>
    ) = SurfEncoder(objectMapper)

    @Bean
    fun options() = Request.Options(
        dataConfig.web.connectionTimeout,
        TimeUnit.MILLISECONDS,
        dataConfig.web.readTimeout,
        TimeUnit.MILLISECONDS,
        true
    )

    @Bean
    fun logger() = FeignLogger(ComponentLogger.logger("WebApi"))
}