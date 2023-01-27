package com.ecommerce.udemy.controllers;

import com.ecommerce.udemy.Dtos.PaymentInfoDto;
import com.ecommerce.udemy.Dtos.PurchaseDto;
import com.ecommerce.udemy.Dtos.PurchaseResponseDto;
import com.ecommerce.udemy.services.CheckoutService;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/checkout")
public class CheckoutController {

    @Autowired
    private CheckoutService service;

    @PostMapping("/purchase")
    public ResponseEntity<PurchaseResponseDto> placeOrder(@RequestBody PurchaseDto purchase) {
        PurchaseResponseDto purchaseResponse = service.placeOrder(purchase);
        return ResponseEntity.ok().body(purchaseResponse);
    }

    @PostMapping("/payment-intent")
    public ResponseEntity<String> createPaymentIntent(@RequestBody PaymentInfoDto paymentInfo) throws StripeException {
        PaymentIntent paymentIntent = service.createPaymentIntent(paymentInfo);
        String paymentStr = paymentIntent.toJson();
        return new ResponseEntity<>(paymentStr, HttpStatus.OK);
    }
}