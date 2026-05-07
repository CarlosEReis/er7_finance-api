package com.er7.finance.infrastructure.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI OpenApiConfig() {
        return new OpenAPI()
            .info(new Info().title("Finance API").version("1.0").description(
                "Documentação da API Finance. Finance é um sistema de controle financeiro para que você possa ter total controle com o seu dinheiro."));
    }
}
