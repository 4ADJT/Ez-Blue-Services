package br.com.ezblue.ezblueservices.domain.parking;

import java.util.UUID;

/**
 * Formulário usado de cadastro do estacionamento.
 *
 * @param clientId  O identificador do cliente que está estacionado no local.
 * @param vehicleId O identificador do veículo que está estacionado no local.
 * @param cityId    O identificador da cidade onde o veículo está estacionado.
 * @param duration  Duração em minutos que o veículo ficara estacionado.
 */
public record RegisterParking(
        UUID clientId,
        UUID vehicleId,
        UUID cityId,
        long duration
) {

    /**
     * Construtor que inicializa um objeto {@code RegisterParking} a partir de uma entidade {@code parkingEntity}.
     *
     * @param parkingEntity O objeto da entidade estacionamento que contém que contem todas suas informações
     */
    public RegisterParking(ParkingEntity parkingEntity) {
        this(
                parkingEntity.getClientId(),
                parkingEntity.getVehicleId(),
                parkingEntity.getCityId(),
                parkingEntity.getDuration()
        );
    }

}
