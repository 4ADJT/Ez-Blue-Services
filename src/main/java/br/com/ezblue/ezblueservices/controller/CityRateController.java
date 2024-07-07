package br.com.ezblue.ezblueservices.controller;

import br.com.ezblue.ezblueservices.domain.rate.*;
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
@Tag(name = "Ez Rate Service", description = "Serviço para gerenciamento das Tarifas das Cidades.")
public class CityRateController {

    @Autowired
    private RateServices rateServices;

    @PostMapping("/{cityId}/rate")
    @Transactional
    @Operation(summary = "Registrar nova tarifa", description = "Registra uma nova tarifa ao uma cidade especifica.")
    public ResponseEntity<DetailRate> registerRate(@PathVariable UUID cityId, @RequestBody @Valid RegisterRate registerRate, UriComponentsBuilder componentsBuilder) {
        var rate = rateServices.register(cityId, registerRate);
        var uri = componentsBuilder.path("/ez-management/city/{cityId}/rate/{id}").buildAndExpand(cityId, rate.id()).toUri();
        return ResponseEntity.created(uri).body(rate);

    }

    @GetMapping("/{cityId}/rate/{id}")
    @Operation(summary = "Detalha tarifa da cidade", description = "Registra a tarifa de uma cidade especifica.")
    public ResponseEntity<DetailRate> getCityRate(@PathVariable UUID cityId, @PathVariable UUID id) {
        return ResponseEntity.ok(rateServices.findCityRateById(cityId, id));
    }

    @GetMapping("/rate")
    @Operation(summary = "Listar tarifas", description = "Lista todas as tarifas registradas sistema.")
    public ResponseEntity<Page<SimpleRate>> listRates(@PageableDefault(size = 10, sort = {"rateValue"}) Pageable pageable) {
        return ResponseEntity.ok(rateServices.findAll(pageable));
    }

    @GetMapping("/rate{id}")
    @Operation(summary = "Detalha tarifa", description = "Exibe os detalhes de uma tarifa específica, incluindo a cidade associada a ela.")
    public ResponseEntity<DetailRate> getRate(@PathVariable UUID id) {
        return ResponseEntity.ok(rateServices.findRateById(id));
    }

    @PutMapping("/{cityId}/rate/{id}")
    @Operation(summary = "Atualiza tarifa da cidade", description = "Atualiza a tarifa de uma cidade especifica.")
    public ResponseEntity<DetailRate> updateCityRate(@PathVariable UUID cityId, @PathVariable UUID id, @RequestBody @Valid UpdateRate updateRate) {
        return ResponseEntity.ok(rateServices.updateCityRateById(cityId, id,updateRate));
    }
}
