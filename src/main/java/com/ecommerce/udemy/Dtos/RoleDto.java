package com.ecommerce.udemy.Dtos;

import com.ecommerce.udemy.entities.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoleDto {

    private Long id;
    private String authority;

    public RoleDto(Role role) {
        id = role.getId();
        authority = role.getAuthority();
    }
}
