package br.com.ezblue.ezblueservices.domain.rate;

import jakarta.validation.constraints.NotNull;

/**
 * Formulário de cadastro da tarifa
 *
 * @param currency  O nome da moeda.
 * @param rateValue O valor da tarifa.
 */
public record RegisterRate(
        @NotNull
        String currency,
        @NotNull
        double rateValue
) {
}
