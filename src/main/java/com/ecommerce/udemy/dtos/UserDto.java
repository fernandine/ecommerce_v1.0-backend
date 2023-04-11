package com.ecommerce.udemy.dtos;

import com.ecommerce.udemy.entities.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto implements Serializable {

    private Long id;
    @NotBlank
    private String firstName;

    private String lastName;

    private String cpf;

    private String phone;

    @JsonFormat(pattern="dd/MM/yyyy")
    private LocalDate birthDay;
    @NotBlank
    @Email
    private String email;

    Set<RoleDto> roles = new HashSet<>();

//    Set<AddressDto> addressList = new HashSet<>();

    public UserDto(User entity) {
        id = entity.getId();
        firstName = entity.getFirstName();
        lastName = entity.getLastName();
        email = entity.getEmail();
        cpf = entity.getCpf();
        birthDay = entity.getBirthDay();
        phone = entity.getPhone();
        entity.getRoles().forEach(role -> this.roles.add(new RoleDto(role)));
        //entity.getAddressList().forEach(address -> this.addressList.add(new AddressDto(address)));
    }
}