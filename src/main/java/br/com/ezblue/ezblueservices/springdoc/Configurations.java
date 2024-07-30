package br.com.ezblue.ezblueservices.springdoc;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Configurations {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI().info(new Info()
                .title("Ez-Blue-Services - API Documentation")
                .version("1.0")
                .description("Esta documentação detalha as APIs do sistema de parquímetro Ez-Blue Zone voltadas para a gestão e controle do sistema.")
                .termsOfService("http://swagger.io/terms/")
                .license(new License()
                        .name("Apache 2.0")
                        .url("http://springdoc.org")));
    }
}
