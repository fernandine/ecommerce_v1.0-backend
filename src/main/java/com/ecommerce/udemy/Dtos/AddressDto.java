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
public class AddressDto implements Serializable {

    private String city;
    private String country;
    private String state;
    private String street;
    private String zipCode;
}
