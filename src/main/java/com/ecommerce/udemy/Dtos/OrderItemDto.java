package com.ecommerce.udemy.Dtos;

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
