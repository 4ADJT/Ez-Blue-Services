package br.com.ezblue.ezblueservices.domain.payment;


public record RegisterPayment(
        String type,
        String cardNumber,
        String carValidity,
        String cardCvv,
        String PixQrcode
) {
}
