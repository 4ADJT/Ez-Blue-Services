package br.com.ezblue.ezblueservices.controller;

import br.com.ezblue.ezblueservices.domain.parking.DetailParking;
import br.com.ezblue.ezblueservices.domain.parking.ParkingService;
import br.com.ezblue.ezblueservices.domain.parking.RegisterParking;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/ez-management/parking")
@Tag(name = "Ez Parking Service", description = "Serviço para cadastro e extensão de horás em uma vaga/estacionamento")
public class ParkingController {

    @Autowired
    private ParkingService parkingService;

    @PostMapping
    @Transactional
    @Operation(summary = "Registrar nova vaga", description = "registra um novo local onde um cliente estacionou")
    public ResponseEntity<DetailParking> registerParking(@RequestBody RegisterParking registerParking, UriComponentsBuilder componentsBuilder)
    {
        DetailParking detailParking = parkingService.register(registerParking);
        URI uri = componentsBuilder.path("/ez-management/parking/{parkingId}").buildAndExpand(registerParking).toUri();
        return ResponseEntity.created(uri).body(detailParking);
    }

    @GetMapping("/teste/{clientID}")
    public ResponseEntity<String> teste(@PathVariable UUID clientID){
        return ResponseEntity.ok(parkingService.exampleMethod(clientID));
    }
}
