package com.osman.library_management.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI libraryManagementOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Library Management System API")
                        .description("REST API for managing books in a library system")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Osman Taha Çakırcı")))
                .externalDocs(new ExternalDocumentation()
                        .description("Project Documentation"));
    }
}
