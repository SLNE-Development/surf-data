package dev.slne.surf.data.core.configuration.feign.interceptor

import feign.RequestInterceptor
import feign.RequestTemplate
import org.springframework.stereotype.Component

@Component
class FeignConfigInterceptor : RequestInterceptor {
    override fun apply(template: RequestTemplate) {
        template.header("User-Agent", "SurfDataClient/1.0")
        template.header("Accept", "application/json")
        template.header("Content-Type", "application/json")
    }
}