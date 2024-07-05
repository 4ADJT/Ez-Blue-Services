package br.com.ezblue.ezblueservices.domain.rate;

import java.util.UUID;

public record DetailRate(
        UUID id,
        String currency,
        double rateValue
) {

    public DetailRate(RateEntity rateEntity) {
        this(
                rateEntity.getId(),
                rateEntity.getCurrency(),
                rateEntity.getRateValue()
        );
    }
}
