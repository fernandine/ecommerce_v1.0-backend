package com.ecommerce.udemy.dtos;
import com.ecommerce.udemy.entities.Address;
import com.ecommerce.udemy.entities.Customer;
import com.ecommerce.udemy.entities.Order;
import com.ecommerce.udemy.entities.OrderItem;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseDto implements Serializable{

    private Customer customer;
    private Address shippingAddress;
    private Address billingAddress;
    private Order order;
    private Set<OrderItem> orderItems;
}
