package org.ronaldp.prueba.loginsys.domain.models.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data

public class PersonaDto {
    private Long id;
    private String nombres;
    private String apellidos;
    private String identificacion;
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern="yyyy-MM-dd", timezone="America/Guayaquil")
    private Date fechaNacimiento;
    private boolean activated;

    public PersonaDto() {
        this.activated = true;
    }

}

