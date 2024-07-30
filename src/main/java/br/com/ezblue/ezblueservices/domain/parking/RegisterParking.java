package br.com.ezblue.ezblueservices.domain.parking;

import br.com.ezblue.ezblueservices.domain.payment.RegisterPayment;

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
        long duration,
        RegisterPayment payment
) {


}
