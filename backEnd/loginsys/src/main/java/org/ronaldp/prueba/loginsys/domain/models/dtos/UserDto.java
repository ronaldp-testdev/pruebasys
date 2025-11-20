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

    private boolean activated;

    public UserDto() {
        this.activated = true;
        this.sessionActive = false;
        this.roles = new ArrayList<>();
    }
}
