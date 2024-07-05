package br.com.ezblue.ezblueservices.controller;

import br.com.ezblue.ezblueservices.domain.city.DetailCity;
import br.com.ezblue.ezblueservices.domain.city.RegisterCity;
import br.com.ezblue.ezblueservices.domain.rate.DetailRate;
import br.com.ezblue.ezblueservices.domain.rate.RateServices;
import br.com.ezblue.ezblueservices.domain.rate.RegisterRate;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.UUID;

@RestController
@RequestMapping("/ez-management/city")
@Tag(name = "Ez Blue Service", description = "Serviço para gerenciamento das Tarifas das Cidades.")
public class CityRateController {

    @Autowired
    private RateServices rateServices;

    @PostMapping("/{cityId}/rate")
    @Transactional
    @Operation(summary = "Registrar nova tarifa", description = "Registra uma nova tarifa ao uma cidade especifica.")
    public ResponseEntity<DetailRate> registerRate(@PathVariable UUID cityId, @RequestBody @Valid RegisterRate registerRate, UriComponentsBuilder componentsBuilder) {
        var rate = rateServices.register(cityId,registerRate);
        var uri = componentsBuilder.path("city/{id}/rate/{id}").buildAndExpand(rate.id()).toUri();
        return ResponseEntity.created(uri).body(rate);
    }
}
