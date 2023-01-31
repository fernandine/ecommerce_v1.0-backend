package com.ecommerce.udemy.services.Impl;

import com.ecommerce.udemy.Dtos.PaymentInfoDto;
import com.ecommerce.udemy.Dtos.PurchaseDto;
import com.ecommerce.udemy.Dtos.PurchaseResponseDto;
import com.ecommerce.udemy.entities.Customer;
import com.ecommerce.udemy.entities.Order;
import com.ecommerce.udemy.entities.OrderItem;
import com.ecommerce.udemy.repositories.CustomerRepository;
import com.ecommerce.udemy.services.CheckoutService;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
public class CheckoutServiceImpl implements CheckoutService {
    private final CustomerRepository customerRepository;

    public CheckoutServiceImpl(CustomerRepository customerRepository,
                               @Value("${stripe.key.secret}") String secretKey) {
        this.customerRepository = customerRepository;
        Stripe.apiKey = secretKey;
    }

    @Override
    @Transactional
    public PurchaseResponseDto placeOrder(PurchaseDto purchase) {
        // retrieve the order
        Order order = purchase.getOrder();
        // generate tracking nuber
        String orderTrackingNumber = generateOrderTrackingNumber();
        order.setOrderTrackingNumber(orderTrackingNumber);

        //populate order with order items
        Set<OrderItem> orderItems = purchase.getOrderItems();
        orderItems.forEach(item -> order.add(item));

        // populate order with billingAddress and shippingAddress
        order.setBillingAddress(purchase.getBillingAddress());
        order.setShippingAddress(purchase.getShippingAddress());

        //populate customer with order
        Customer customer = purchase.getCustomer();

        String theEmail = customer.getEmail();

        Customer customerFromDB = customerRepository.findByEmail(theEmail);

        if (customerFromDB != null) {
            customer = customerFromDB;
        }

        customer.add(order);

        // save to the database
        customerRepository.save(customer);

        //return a response
        return new PurchaseResponseDto(orderTrackingNumber);
    }

    @Override
    public PaymentIntent createPaymentIntent(PaymentInfoDto paymentInfoDTO) throws StripeException {
        List<String> paymentMethodTypes = new ArrayList<>();
        paymentMethodTypes.add("card");

        Map<String, Object> params = new HashMap<>();
        params.put("amount", paymentInfoDTO.getAmount());
        params.put("currency", paymentInfoDTO.getCurrency());
        params.put("payment_method_types", paymentMethodTypes);
        params.put("description","Shop Purchase");
        params.put("receipt_email",paymentInfoDTO.getReceiptEmail());
        return PaymentIntent.create(params);
    }

    private String generateOrderTrackingNumber() {
        // generate a random UUID number
        return UUID.randomUUID().toString();
    }
}
