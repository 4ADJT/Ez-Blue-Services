package br.com.ezblue.ezblueservices.domain.city;

import java.util.UUID;

/**
 * Objeto Record usado para devolver os dados simplificados da cidade.
 *
 * @param id      O identificador único da cidade cadastrada.
 * @param city    O nome da cidade.
 * @param state   O nome do estado onde a cidade está localizada.
 * @param country O nome do país onde a cidade está localizada.
 */
public record SimpleCity(
        UUID id,
        String city,
        String state,
        String country
) {

    /**
     * Construtor que inicializa um objeto {@code SimpleCity} a partir de uma entidade {@code CityEntity}.
     *
     * @param cityEntity O objeto da entidade da cidade que contém as informações simplificada da cidade.
     */
    public SimpleCity(CityEntity cityEntity) {
        this(
                cityEntity.getId(),
                cityEntity.getCity(),
                cityEntity.getState(),
                cityEntity.getCountry()
        );
    }
}
