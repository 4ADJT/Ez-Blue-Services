package br.com.ezblue.ezblueservices.controller;

import br.com.ezblue.ezblueservices.domain.city.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.UUID;

@RestController
@RequestMapping("/ez-management/city")
@Tag(name = "Ez City Service", description = "Serviço para gerenciamento de Cidades.")
public class CityController {

    @Autowired
    private CityServices cityServices;

    @PostMapping()
    @Transactional
    @Operation(summary = "Registrar nova Cidade", description = "Registra uma nova cidade no sistema.")
    public ResponseEntity<DetailCity> registerCity(@RequestBody @Valid RegisterCity registerCity, UriComponentsBuilder componentsBuilder) {
        var city = cityServices.register(registerCity);
        var uri = componentsBuilder.path("/ez-management/city/{id}").buildAndExpand(city.id()).toUri();
        return ResponseEntity.created(uri).body(city);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Detalhar Cidade", description = "Detalha uma cidade no sistema.")
    public ResponseEntity<DetailCity> detailCity(@PathVariable UUID id) {
        return ResponseEntity.ok(cityServices.ConvertToDetailCity(cityServices.findById(id)));
    }

    @GetMapping()
    @Operation(summary = "Listar Cidades", description = "Lista todas as cidade registradas sistema.")
    public ResponseEntity<Page<SimpleCity>> listCity(@PageableDefault(size = 10, sort = {"city"}) Pageable pageable) {
        return ResponseEntity.ok(cityServices.findAll(pageable));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar Cidade", description = "Atualiza uma cidade especifica registradas sistema.")
    public ResponseEntity<DetailCity> updateCity(@PathVariable UUID id, @RequestBody @Valid UpdateCity updateCity) {
        return ResponseEntity.ok(cityServices.updateCityById(id, updateCity));
    }

}