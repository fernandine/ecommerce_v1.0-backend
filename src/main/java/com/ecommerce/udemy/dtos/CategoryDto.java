package com.ecommerce.udemy.dtos;

import com.ecommerce.udemy.entities.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto implements Serializable {

    private Long id;
    private String name;

    public CategoryDto(Category entity) {

        id = entity.getId();
        name = entity.getName();
    }
}
