package br.com.ezblue.ezblueservices.domain.parking;

import java.util.UUID;

/**
 * Objeto Record usado para devolver os dados detalhados do estacionamento.
 *
 * @param id        O identificador único do local estacionado cadastrado.
 * @param clientId  O identificador do cliente que está estacionado no local.
 * @param vehicleId O identificador do veículo que está estacionado no local.
 * @param cityId    O identificador da cidade onde o veículo está estacionado.
 * @param duration  Duração em minutos que o veículo ficara estacionado.
 */
public record DetailParking(
        UUID id,
        UUID clientId,
        UUID vehicleId,
        UUID cityId,
        long duration
) {

    /**
     * Construtor que inicializa um objeto {@code DetailParking} a partir de uma entidade {@code parkingEntity}.
     *
     * @param parkingEntity O objeto da entidade estacionamento que contém que contem todas suas informações
     */
    public DetailParking(ParkingEntity parkingEntity) {
        this(
                parkingEntity.getId(),
                parkingEntity.getClientId(),
                parkingEntity.getVehicleId(),
                parkingEntity.getCityId(),
                parkingEntity.getDuration()
        );
    }

}
