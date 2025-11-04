package dev.slne.surf.data.core.configuration

import org.springframework.boot.autoconfigure.ImportAutoConfiguration
import org.springframework.boot.jackson.autoconfigure.JacksonAutoConfiguration
import org.springframework.boot.jackson.autoconfigure.JsonMapperBuilderCustomizer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import tools.jackson.databind.DeserializationFeature
import tools.jackson.databind.module.SimpleModule
import tools.jackson.module.kotlin.KotlinFeature
import tools.jackson.module.kotlin.KotlinModule

@Configuration
@ImportAutoConfiguration(JacksonAutoConfiguration::class)
class DataObjectMapperConfiguration {
    @Bean
    @Primary
    fun jsonMapperCustomizer(
        customJacksonSerialization: SimpleModule
    ) = JsonMapperBuilderCustomizer { builder ->
        builder.disable(
            DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
            DeserializationFeature.FAIL_ON_INVALID_SUBTYPE,
        )

        builder.enable(
            DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT
        )

        builder.addModule(
            KotlinModule.Builder()
                .enable(KotlinFeature.StrictNullChecks)
                .build()
        )
    }

    @Bean
    fun customJacksonSerialization() = SimpleModule().apply {

    }
}