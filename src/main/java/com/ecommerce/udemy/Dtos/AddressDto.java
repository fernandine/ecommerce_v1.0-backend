package com.ecommerce.udemy.Dtos;

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
