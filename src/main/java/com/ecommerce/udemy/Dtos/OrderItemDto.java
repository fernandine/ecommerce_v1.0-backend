package com.ecommerce.udemy.Dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemDto implements Serializable {

    private String imageUrl;
    private Integer quantity;
    private BigDecimal unitPrice;
    private Long productId;
}
