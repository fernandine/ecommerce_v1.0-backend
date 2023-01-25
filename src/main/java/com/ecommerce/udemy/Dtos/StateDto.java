package com.ecommerce.udemy.Dtos;

import com.ecommerce.udemy.entities.Country;
import com.ecommerce.udemy.entities.State;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StateDto implements Serializable {

    private Long id;
    private String name;
    private Long countryId;

    public StateDto(State entity) {
        id = entity.getId();
        name = entity.getName();
        countryId = entity.getCountry().getId();
    }
}