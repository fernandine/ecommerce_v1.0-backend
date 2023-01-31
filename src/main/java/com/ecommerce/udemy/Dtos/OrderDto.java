package com.ecommerce.udemy.Dtos;

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
}
