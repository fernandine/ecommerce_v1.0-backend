package com.ecommerce.udemy.Dtos;

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
