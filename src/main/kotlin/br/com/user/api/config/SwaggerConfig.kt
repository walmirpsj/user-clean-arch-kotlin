package br.com.user.api.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Contact
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2
import java.util.*

@Configuration
@EnableSwagger2
class SwaggerConfig{

    @Value("\${spring.application.name}")
    var name: String? = null

    @Value("\${api.project.version}")
    var version: String? = null

    @Bean
    fun api(): Docket {
        return Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(PathSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("br.com.user.api"))
                .build()
                .apiInfo(apiInfo())
    }

    private fun apiInfo(): ApiInfo {
        return ApiInfo(
                name,
                "User API to register, update, find and delete users",
                version,
                "Terms of Service",
                Contact("UserApi", "http://localhost:8080", "walmir.psj@gmail.com"),
                "License of API",
                "API license URL",
                Collections.emptyList()
        )
    }
}