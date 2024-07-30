package br.com.ezblue.ezblueservices.openfeign;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

/**
 * Classe de configuração para habilitar o Feign Client no microserviço Ez-Blue-Services.
 * <p>
 * Esta classe utiliza a anotação @EnableFeignClients para habilitar a funcionalidade do Feign no Spring Boot,
 * permitindo que o microserviço Ez-Blue-Services utilize interfaces Feign Client para se comunicar com outros serviços.
 * </p>
 * <p>
 * O atributo basePackages na anotação @EnableFeignClients especifica os pacotes onde o Spring deve procurar
 * por interfaces anotadas com @FeignClient.
 * </p>
 */
@Configuration
@EnableFeignClients(basePackages = "br.com.ezblue.ezblueservices.openfeign")
public class FeignConfig {
}

