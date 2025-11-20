package org.ronaldp.prueba.loginsys.domain.models.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


import java.util.ArrayList;
import java.util.List;

@Data

public class UserDto {
    private Long id;

    private String email;
    private String username;

    private boolean sessionActive;

    private String status;
    private PersonaDto persona;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private boolean admin;

    private List<RoleDto> roles;

    public UserDto() {
        this.sessionActive = true;
        this.roles = new ArrayList<>();
    }
}
