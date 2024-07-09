package br.com.ezblue.ezblueservices.domain.parking;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Objeto Record usado para devolver os dados simplificados do estacionamento.
 *
 * @param id        O identificador único do local estacionado cadastrado.
 * @param clientId  O identificador do cliente que está estacionado no local.
 * @param vehicleId O identificador do veículo que está estacionado no local.
 * @param cityId    O identificador da cidade onde o veículo está estacionado.
 */
public record SimpleParking(
        UUID id,
        UUID clientId,
        UUID vehicleId,
        UUID cityId
) {

    /**
     * Construtor que inicializa um objeto {@code SimpleParking} a partir de uma entidade {@code parkingEntity}.
     *
     * @param parkingEntity O objeto da entidade estacionamento que contém que contem todas suas informações
     */
    public SimpleParking(ParkingEntity parkingEntity)
    {
        this(
                parkingEntity.getId(),
                parkingEntity.getClientId(),
                parkingEntity.getVehicleId(),
                parkingEntity.getCityId()
        );
    }

}
