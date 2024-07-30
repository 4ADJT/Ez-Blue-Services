package br.com.ezblue.ezblueservices.domain.rate;

import br.com.ezblue.ezblueservices.domain.city.SimpleCity;

import java.util.UUID;

/**
 * Objeto Record usado para devolver os dados detalhados da Tarifa.
 *
 * @param id        O identificador único da Tarifa cadastrada.
 * @param currency  O tipo da moeda.
 * @param rateValue O valor da tarifa.
 * @param city      Objeto contendo os dados simples da cidade associada à tarifa.
 */
public record DetailRate(
        UUID id,
        String currency,
        double rateValue,
        SimpleCity city
) {

    /**
     * Construtor que inicializa um objeto {@code DetailRate} a partir de uma entidade {@code rateEntity}.
     *
     * @param rateEntity O objeto da entidade da tarifa que contém as informações simples da cidade.
     */
    public DetailRate(RateEntity rateEntity) {
        this(
                rateEntity.getId(),
                rateEntity.getCurrency(),
                rateEntity.getRateValue(),
                rateEntity.getCity() != null ? new SimpleCity(rateEntity.getCity()) : null
        );
    }
}
