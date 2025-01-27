package com.fuinha.example.config

import io.swagger.v3.oas.models.Components
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.security.SecurityRequirement
import io.swagger.v3.oas.models.security.SecurityScheme
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SwaggerConfig {

    @Bean
    fun customOpenAPI(): OpenAPI {
        val schemeName = "bearerAuth"
        return OpenAPI()
            .info(
                Info()
                    .title("Exemple 2 API")
                    .version("1.0.0")
                    .description("This is the API collection for the Exemple 2 application.")
            ).addSecurityItem(
                SecurityRequirement().addList(schemeName)
            ).components(
                Components()
                    .addSecuritySchemes(
                        schemeName,
                        SecurityScheme().name(schemeName)
                            .type(SecurityScheme.Type.HTTP)
                            .scheme("bearer")
                            .bearerFormat("JWT")
                    )
            )
    }
}