package com.ecommerce.udemy.services;

import com.ecommerce.udemy.Dtos.PaymentInfoDto;
import com.ecommerce.udemy.Dtos.PurchaseDto;
import com.ecommerce.udemy.Dtos.PurchaseResponseDto;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;

public interface CheckoutService {
    PurchaseResponseDto placeOrder(PurchaseDto purchase);
    PaymentIntent createPaymentIntent(PaymentInfoDto paymentInfoDto) throws StripeException;
}
