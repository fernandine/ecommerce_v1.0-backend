package com.ecommerce.udemy.services;

public interface CheckoutService {
    PurchaseResponseDTO placeOrder(PurchaseDTO purchase);
    PaymentIntent createPaymentIntent(PaymentInfoDTO paymentInfoDTO) throws StripeException;
}
