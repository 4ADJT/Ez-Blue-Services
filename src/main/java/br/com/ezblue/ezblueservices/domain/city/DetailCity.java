package br.com.ezblue.ezblueservices.domain.city;

import br.com.ezblue.ezblueservices.domain.rate.SimpleRate;

import java.util.UUID;

/**
 * Objeto Record usado para devolver os dados detalhados da cidade.
 *
 * @param id      O identificador único da cidade cadastrada.
 * @param city    O nome da cidade.
 * @param state   O nome do estado onde a cidade está localizada.
 * @param country O nome do país onde a cidade está localizada.
 * @param rate    Objeto contendo os dados simples das tarifas associadas à cidade.
 */
public record DetailCity(
        UUID id,
        String city,
        String state,
        String country,
        SimpleRate rate

) {

    /**
     * Construtor que inicializa um objeto {@code DetailCity} a partir de uma entidade {@code CityEntity}.
     *
     * @param cityEntity O objeto da entidade da cidade que contém as informações detalhadas da cidade.
     */
    public DetailCity(CityEntity cityEntity) {
        this(
                cityEntity.getId(),
                cityEntity.getCity(),
                cityEntity.getState(),
                cityEntity.getCountry(),
                cityEntity.getRate() != null ? new SimpleRate(cityEntity.getRate()) : null
        );
    }

}
