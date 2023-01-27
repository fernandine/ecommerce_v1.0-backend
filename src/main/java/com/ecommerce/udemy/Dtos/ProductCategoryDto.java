package com.ecommerce.udemy.Dtos;

import com.ecommerce.udemy.entities.ProductCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductCategoryDto implements Serializable {

    private Long id;
    private String categoryName;

    public ProductCategoryDto(ProductCategory entity) {

        id = entity.getId();
        categoryName = entity.getCategoryName();
    }
}
