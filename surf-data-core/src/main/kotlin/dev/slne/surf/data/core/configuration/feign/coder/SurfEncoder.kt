package dev.slne.surf.data.core.configuration.feign.coder

import com.fasterxml.jackson.databind.ObjectMapper
import feign.RequestTemplate
import feign.codec.Encoder
import org.springframework.beans.factory.ObjectProvider
import org.springframework.stereotype.Component
import java.lang.reflect.Type

@Component
class SurfEncoder(
    private val objectMapper: ObjectProvider<ObjectMapper>
) : Encoder {
    override fun encode(
        `object`: Any?,
        bodyType: Type,
        template: RequestTemplate
    ) {
        template.body(objectMapper.getIfAvailable()?.writeValueAsString(`object`))
    }
}