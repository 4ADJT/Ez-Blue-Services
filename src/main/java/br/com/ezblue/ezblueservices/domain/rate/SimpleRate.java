package br.com.ezblue.ezblueservices.domain.rate;

import java.util.UUID;

/**
 * Objeto Record usado para devolver os dados simplíficados da tarifa.
 *
 * @param id        O identificador único da Tarifa cadastrada.
 * @param currency  O tipo da moeda.
 * @param rateValue O valor da tarifa.
 */
public record SimpleRate(
        UUID id,
        String currency,
        double rateValue
) {

    /**
     * Construtor que inicializa um objeto {@code SimpleRate} a partir de uma entidade {@code rateEntity}.
     *
     * @param rateEntity O objeto da entidade da tarifa que contém as informações simples da cidade.
     */
    public SimpleRate(RateEntity rateEntity) {
        this(
                rateEntity.getId(),
                rateEntity.getCurrency(),
                rateEntity.getRateValue()
        );
    }
}
