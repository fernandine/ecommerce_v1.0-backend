package com.ecommerce.udemy.Dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentInfoDto implements Serializable {

    private int amount;
    private String currency;
    private String receiptEmail;
}
