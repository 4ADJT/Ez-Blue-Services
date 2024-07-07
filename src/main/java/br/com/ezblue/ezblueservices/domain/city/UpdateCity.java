package br.com.ezblue.ezblueservices.domain.city;

/**
 * Formulário de atualização da cidade.
 *
 * @param city    O nome da cidade.
 * @param state   O nome do estado onde a cidade está localizada.
 * @param country O nome do país onde a cidade está localizada.
 */
public record UpdateCity(
        String city,
        String state,
        String country
) {
}
