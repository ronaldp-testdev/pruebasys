package org.ronaldp.prueba.loginsys.domain.models.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ronaldp.prueba.loginsys.domain.models.entities.Role;

import java.util.ArrayList;
import java.util.List;

@Data
public class RolOpcionesDto {
    private Long id;
    private String nombreOpcion;
    private boolean activated;
    private List<RoleDto> roles;

    public RolOpcionesDto() {
        this.roles = new ArrayList<>();
        this.activated = true;
    }
}
