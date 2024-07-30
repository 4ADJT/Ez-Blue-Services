package br.com.ezblue.ezblueservices.domain.payment;


public record RegisterPayment(
        String paymentType,
        String cardType,
        String cardNumber,
        String carValidity,
        String cardCvv,
        String key
) {
}
