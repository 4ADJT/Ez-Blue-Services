package br.com.ezblue.ezblueservices.domain.rate;

import jakarta.validation.constraints.NotNull;

public record RegisterRate(
        @NotNull
        String currency,
        @NotNull
        double rateValue
) {
}
