package com.ecommerce.udemy.dtos;

import com.ecommerce.udemy.entities.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto implements Serializable {

    private BigDecimal totalPrice;
    private Integer totalQuantity;
    private String orderTrackingNumber;
    private Date dateCreated;

    public OrderDto(Order entity) {
        totalPrice = entity.getTotalPrice();
        totalQuantity = entity.getTotalQuantity();
        orderTrackingNumber = entity.getOrderTrackingNumber();
        dateCreated = entity.getDateCreated();
    }
}
