package br.com.ezblue.ezblueservices.domain.city;

import java.util.UUID;

public record DetailCity(
        UUID id,
        String city,
        String state,
        String country
) {
    public DetailCity(CityEntity cityEntity) {
        this(
                cityEntity.getId(),
                cityEntity.getCity(),
                cityEntity.getState(),
                cityEntity.getCountry()
        );
    }
}
