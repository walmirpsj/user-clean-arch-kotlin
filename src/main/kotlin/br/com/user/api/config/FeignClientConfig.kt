package br.com.user.api.config

import feign.Logger
import feign.RequestInterceptor
import feign.RequestTemplate
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpHeaders
import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletRequestAttributes


@Configuration
 class FeignClientConfig {

    @Bean
     fun requestInterceptorAuth(): RequestInterceptor? {
        return RequestInterceptor { requestTemplate: RequestTemplate ->
            val requestAttributes = RequestContextHolder.getRequestAttributes()
            val servletRequestAttributes = requestAttributes as ServletRequestAttributes
            val httpServletRequest = servletRequestAttributes.request
            requestTemplate.header(HttpHeaders.AUTHORIZATION, httpServletRequest.getHeader(HttpHeaders.AUTHORIZATION))
        }
    }

    @Bean
    fun level(): Logger.Level? {
        return Logger.Level.FULL
    }
}