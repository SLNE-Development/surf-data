package dev.slne.surf.data.core.configuration.feign.interceptor

import dev.slne.surf.data.core.config.dataConfig
import feign.RequestInterceptor
import feign.RequestTemplate
import org.springframework.stereotype.Component

@Component
class FeignAuthenticationInterceptor : RequestInterceptor {
    override fun apply(template: RequestTemplate) {
        template.header("Authorization", "Bearer ${dataConfig.web.bearerToken}")
    }
}