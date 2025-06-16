package com.chalnakchalnak.product_service.common.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@OpenAPIDefinition(
        info = @io.swagger.v3.oas.annotations.info.Info(
                title = "Product-Service API",
                version = "v1",
                description = "일반 상품 서비스"
        ), security = {
        @io.swagger.v3.oas.annotations.security.SecurityRequirement(name = "Bearer Auth")
}
)

@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi publicApi() {
        String[] paths = {"/api/v1/**"};
        return GroupedOpenApi.builder()
                .group("public-api")
                .pathsToMatch(paths)
                .build();
    }
}