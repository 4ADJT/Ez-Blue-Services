package br.com.ezblue.ezblueservices.domain.parking;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Formulário usado de cadastro do estacionamento.
 *
 * @param clientId  O identificador do cliente que está estacionado no local.
 * @param vehicleId O identificador do veículo que está estacionado no local.
 * @param cityId    O identificador da cidade onde o veículo está estacionado.
 * @param startTime O momento exato onde o cliente estacionou seu veículo.
 * @param endTime   O momento exato onde o cliente saiu com seu veículo.
 */
public record RegisterParking(
        UUID clientId,
        UUID vehicleId,
        UUID cityId,
        LocalDateTime startTime,
        LocalDateTime endTime
) {

    /**
     * Construtor que inicializa um objeto {@code RegisterParking} a partir de uma entidade {@code parkingEntity}.
     *
     * @param parkingEntity O objeto da entidade estacionamento que contém que contem todas suas informações
     */
    public RegisterParking(ParkingEntity parkingEntity)
    {
        this(
                parkingEntity.getClientId(),
                parkingEntity.getVehicleId(),
                parkingEntity.getCityId(),
                parkingEntity.getStartTime(),
                parkingEntity.getEndTime()
        );
    }

}
