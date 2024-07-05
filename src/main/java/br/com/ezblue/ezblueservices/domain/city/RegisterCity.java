package br.com.ezblue.ezblueservices.domain.city;

import jakarta.validation.constraints.NotNull;

public record RegisterCity(
        @NotNull
        String city,
        @NotNull
        String state,
        @NotNull
        String country
) {
}
