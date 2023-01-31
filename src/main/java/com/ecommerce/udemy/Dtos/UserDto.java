package com.ecommerce.udemy.Dtos;

import com.ecommerce.udemy.entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto implements Serializable {

    private Long id;

    @NotBlank(message = "Campo Obrigatório")
    private String firstName;
    private String lastName;
    @Email(message = "Favor entrar com email válido")
    private String email;

    Set<RoleDto> roles = new HashSet<>();

    public UserDto(User entity) {
        id = entity.getId();
        firstName = entity.getFirstName();
        lastName = entity.getLastName();
        email = entity.getEmail();
        entity.getRoles().forEach(role -> this.roles.add(new RoleDto(role)));
    }
}
