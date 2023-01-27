package com.ecommerce.udemy.Dtos;

import com.ecommerce.udemy.entities.Country;
import com.ecommerce.udemy.entities.State;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CountryDto implements Serializable {

    private Long id;
    private String code;
    private String name;

    public CountryDto(Country entity) {
        id = entity.getId();
        code = entity.getCode();
        name = entity.getName();
    }
}
