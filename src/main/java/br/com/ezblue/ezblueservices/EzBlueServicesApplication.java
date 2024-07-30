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

    // TODO: +Gerenciamento de Tarifas de Estacionamento: CRUD de tarifas de
    // estacionamento por cidade (e possivelmente por bairro).
    // TODO: +Registro de Estacionamento: Registrar onde e por quanto tempo cada
    // veículo ficou estacionado.
    // TODO: +-API de Localização: API para identificar a localização onde o cliente
    // está parando.

    // Funcionalidades Adicionais:
    // TODO: -Integração com Mapas e Geolocalização: Utilizar APIs de mapas para
    // fornecer localização precisa e mostrar disponibilidade de vagas.
    // TODO: -Gerenciamento de Tarifas Dinâmicas: Implementar tarifas dinâmicas
    // baseadas na demanda, horário e localização.
    // TODO: -Relatórios e Estatísticas: Geração de relatórios e estatísticas de uso
    // para administração das cidades.
    // TODO: -Integração com Serviços de Monitoramento: Interface para integrar com
    // serviços de monitoramento de estacionamento (por exemplo, sensores de vagas).
    // TODO: + Notificações e Alertas: Enviar notificações sobre vagas disponíveis,
    // mudanças de tarifas, etc.

}
