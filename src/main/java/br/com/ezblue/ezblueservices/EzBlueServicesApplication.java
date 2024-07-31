package br.com.ezblue.ezblueservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;

@SpringBootApplication
@OpenAPIDefinition(servers = { @Server(url = "/", description = "Default Server URL") })
public class EzBlueServicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(EzBlueServicesApplication.class, args);
    }

}
