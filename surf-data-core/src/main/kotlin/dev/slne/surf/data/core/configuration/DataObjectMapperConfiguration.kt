package dev.slne.surf.data.core.configuration

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule
import org.springframework.boot.autoconfigure.ImportAutoConfiguration
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration
import org.springframework.cloud.openfeign.FeignFormatterRegistrar
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.format.datetime.standard.DateTimeFormatterRegistrar
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder
import java.time.format.DateTimeFormatter


@Configuration
@ImportAutoConfiguration(JacksonAutoConfiguration::class)
class DataObjectMapperConfiguration {
    private val dateFormatter: DateTimeFormatter =
        DateTimeFormatter.ofPattern("yyyy-MM-dd")

    private val timeFormatter: DateTimeFormatter =
        DateTimeFormatter.ofPattern("HH:mm:ss")

    private val dateTimeFormatter: DateTimeFormatter =
        DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")

    @Bean
    fun feignFormatterRegistrar() = FeignFormatterRegistrar { registry ->
        val registrar = DateTimeFormatterRegistrar()

        registrar.setUseIsoFormat(false)
        registrar.setDateFormatter(dateFormatter)
        registrar.setTimeFormatter(timeFormatter)
        registrar.setDateTimeFormatter(dateTimeFormatter)
        registrar.registerFormatters(registry)
    }

    @Bean
    @Primary
    fun objectMapper(
        builder: Jackson2ObjectMapperBuilder
    ) = builder.build<ObjectMapper>().apply {
        println("Configuring ObjectMapper: $this")
        
        configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        configure(DeserializationFeature.FAIL_ON_INVALID_SUBTYPE, false);
        configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);

        configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

        registerModules(
            KotlinModule.Builder().build(),
            ParameterNamesModule(),
            JavaTimeModule(),
            Jdk8Module()
        )

        println("Registered ObjectMapper: $this, modules: ${this.registeredModuleIds}")
    }
}