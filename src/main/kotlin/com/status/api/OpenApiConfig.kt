package com.status.api

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class OpenApiConfig {

    @Bean
    fun openAPI(): OpenAPI {
//        val tokenName = "jwtToken"
        return OpenAPI()
            .info(
                Info()
                    .title("STATUS API")
                    .description("STATUS API 명세서")
                    .version("1.0.0")
            )
//            .addSecurityItem(
//                SecurityRequirement()
//                    .addList(tokenName)
//            )
//            .components(
//                Components()
//                    .addSecuritySchemes(
//                        tokenName,
//                        SecurityScheme()
//                            .type(SecurityScheme.Type.HTTP)
//                            .scheme("bearer")
//                            .bearerFormat("JWT")
//                    )
//            )
    }
}
