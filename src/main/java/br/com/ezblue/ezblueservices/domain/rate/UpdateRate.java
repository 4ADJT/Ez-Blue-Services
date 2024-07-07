package br.com.ezblue.ezblueservices.domain.rate;

/**
 * Formulário de atualização dos dados da tarifa.
 *
 * @param currency  O nome da moeda.
 * @param rateValue O valor da tarifa.
 */
public record UpdateRate(
        String currency,
        double rateValue
) {
}
