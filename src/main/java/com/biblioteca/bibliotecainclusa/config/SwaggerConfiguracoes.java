package com.biblioteca.bibliotecainclusa.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguracoes {

    @Bean
    public OpenAPI bibliotecaOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Biblioteca Inclusiva API")
                        .description("API que eu criei para gerenciamento de uma bilioteca com livros com acessibilidade a todos")
                        .version("1.0"));
    }
}