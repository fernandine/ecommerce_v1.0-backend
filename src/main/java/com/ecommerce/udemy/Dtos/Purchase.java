package com.ecommerce.udemy.Dtos;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Purchase implements Serializable{

    private Customer customer;
    private Address shippingAddress;
    private Address billingAddress;
    private Order order;
    private Set<OrderItem> orderItems;
}
