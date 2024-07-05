package br.com.ezblue.ezblueservices.controller;

import br.com.ezblue.ezblueservices.domain.city.CityServices;
import br.com.ezblue.ezblueservices.domain.city.DetailCity;
import br.com.ezblue.ezblueservices.domain.city.RegisterCity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/ez-management/city")
@Tag(name = "Ez Blue Service", description = "Serviço para gerenciamento de Cidades.")
public class CityController {

    @Autowired
    private CityServices cityServices;

    @PostMapping
    @Transactional
    @Operation(summary = "Registrar nova Cidade", description = "Registra uma nova cidade no sistema.")
    public ResponseEntity<DetailCity> registerClient(@RequestBody @Valid RegisterCity registerCity, UriComponentsBuilder componentsBuilder) {
        var city = cityServices.register(registerCity);
        var uri = componentsBuilder.path("city/{id}").buildAndExpand(city.id()).toUri();
        return ResponseEntity.created(uri).body(city);
    }

}
