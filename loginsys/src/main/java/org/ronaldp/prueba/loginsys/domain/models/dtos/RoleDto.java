package org.ronaldp.prueba.loginsys.domain.models.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class RoleDto {
    private long id;
    private String name;

    private boolean activated;

    public RoleDto() {
        this.activated = true;
    }
}
