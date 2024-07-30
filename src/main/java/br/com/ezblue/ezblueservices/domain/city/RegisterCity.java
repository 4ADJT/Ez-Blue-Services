package br.com.ezblue.ezblueservices.domain.city;

import jakarta.validation.constraints.NotNull;

/**
 * Formulário de cadastro da cidade
 *
 * @param city    O nome da cidade.
 * @param state   O nome do estado onde a cidade está localizada.
 * @param country O nome do país onde a cidade está localizada.
 */
public record RegisterCity(
        @NotNull
        String city,
        @NotNull
        String state,
        @NotNull
        String country
) {
}
