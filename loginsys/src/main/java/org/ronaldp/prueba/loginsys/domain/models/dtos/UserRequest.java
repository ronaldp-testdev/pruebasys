package org.ronaldp.prueba.loginsys.domain.models.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserRequest implements IUser{
    //@NotBlank
    private String name;
    //@NotBlank
    private String lastname;
    //@NotEmpty
    //@Email
    private String email;
    //@NotBlank
    @Size(min=4, max=12)
    private String username;

    private boolean admin;

}
