package com.ecommerce.udemy.Dtos;

import com.ecommerce.udemy.entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto implements Serializable {

    private Long id;
    private String name;
    private String username;
    private String email;
    private String password;

    public UserDto(User entity) {
        id = entity.getId();
    }

}
