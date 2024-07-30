package br.com.ezblue.ezblueservices.openfeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;
import java.util.UUID;

/**
 * Interface Feign Client para comunicação com o serviço Ez-Client-Services.
 * <p>
 * Esta interface permite que o microserviço Ez-Blue-Services se comunique com o microserviço Ez-Client-Services
 * através de HTTP de forma declarativa. O Feign Client resolve o endereço do microserviço alvo através do
 * Eureka Server, utilizando o nome do serviço registrado.
 * </p>
 * <p>
 * As anotações Spring MVC como @GetMapping são usadas para definir os endpoints que o Feign Client deve
 * chamar no serviço Ez-Client-Services.
 * </p>
 */
@FeignClient(name = "EZ-CLIENT-SERVICES")
public interface EzClientServiceOpenFeign {

    /**
     * Obtém os detalhes do cliente por ID.
     * <p>
     * Este método mapeia para o endpoint HTTP GET /clients/{id} do serviço Ez-Client-Services.
     * </p>
     *
     * @param id O UUID do cliente que está sendo buscado.
     * @return Uma String contendo os detalhes do cliente.
     */
    @GetMapping("/client/{id}")
    Map<String, Object> getClientById(@PathVariable("id") UUID id);

}

