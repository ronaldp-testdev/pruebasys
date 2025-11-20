package org.ronaldp.prueba.loginsys.domain.models.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import org.ronaldp.prueba.loginsys.domain.models.entities.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class SessionDto {

    private Long id;
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern="yyyy-MM-dd", timezone="America/Guayaquil")
    private Date fechaIngreso;
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern="yyyy-MM-dd", timezone="America/Guayaquil")
    private Date fechaCierre;
    private UserDto usuario;
    private boolean activated;

    public SessionDto() {
        this.activated = true;
    }


}
