package com.ecommerce.udemy.controllers;

@RestController
@RequestMapping(value = "/checkout")
public class CheckoutResource {

    @Autowired
    private CheckoutService service;

    @PostMapping("/purchase")
    public ResponseEntity<PurchaseResponseDTO> placeOrder(@RequestBody PurchaseDTO purchase) {
        PurchaseResponseDTO purchaseResponse = service.placeOrder(purchase);
        return ResponseEntity.ok().body(purchaseResponse);
    }

    @PostMapping("/payment-intent")
    public ResponseEntity<String> createPaymentIntent(@RequestBody PaymentInfoDTO paymentInfo) throws StripeException {
        PaymentIntent paymentIntent = service.createPaymentIntent(paymentInfo);
        String paymentStr = paymentIntent.toJson();
        return new ResponseEntity<>(paymentStr, HttpStatus.OK);
    }
}