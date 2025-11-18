package dev.slne.surf.data.core.configuration.feign.coder

import com.fasterxml.jackson.databind.ObjectMapper
import feign.Response
import feign.codec.Decoder
import org.springframework.beans.factory.ObjectProvider
import java.lang.reflect.Type

class SurfDecoder(
    private val objectMapper: ObjectProvider<ObjectMapper>
) : Decoder {
    override fun decode(
        response: Response,
        type: Type
    ): Any? = objectMapper.getIfAvailable().let { mapper ->
        println("Trying to decode response using mapper: $mapper")
        response.body().asInputStream().use { inputStream ->
            mapper?.readValue(inputStream, mapper.typeFactory.constructType(type))
        }
    }
}