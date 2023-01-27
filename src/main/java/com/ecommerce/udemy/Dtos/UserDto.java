package com.ecommerce.udemy.Dtos;

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
