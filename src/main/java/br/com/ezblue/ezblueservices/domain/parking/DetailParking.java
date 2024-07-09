package br.com.ezblue.ezblueservices.domain.parking;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Objeto Record usado para devolver os dados detalhados do estacionamento.
 *
 * @param id        O identificador único do local estacionado cadastrado.
 * @param clientId  O identificador do cliente que está estacionado no local.
 * @param vehicleId O identificador do veículo que está estacionado no local.
 * @param cityId    O identificador da cidade onde o veículo está estacionado.
 * @param startTime O momento exato onde o cliente estacionou seu veículo.
 * @param endTime   O momento exato onde o cliente saiu com seu veículo.
 */
public record DetailParking(
        UUID id,
        UUID clientId,
        UUID vehicleId,
        UUID cityId,
        LocalDateTime startTime,
        LocalDateTime endTime
) {

    /**
     * Construtor que inicializa um objeto {@code DetailParking} a partir de uma entidade {@code parkingEntity}.
     *
     * @param parkingEntity O objeto da entidade estacionamento que contém que contem todas suas informações
     */
    public DetailParking(ParkingEntity parkingEntity)
    {
        this(
                parkingEntity.getId(),
                parkingEntity.getClientId(),
                parkingEntity.getVehicleId(),
                parkingEntity.getCityId(),
                parkingEntity.getStartTime(),
                parkingEntity.getEndTime()
        );
    }

}
