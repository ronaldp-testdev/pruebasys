package org.ronaldp.prueba.loginsys.domain.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "sessions")
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha_ingreso")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIngreso;

    @Column(name = "fecha_cierre")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCierre;

    @ManyToOne
    @JoinColumn(name = "usuarios_id_usuario")
    @JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
    private User usuario;

    private boolean activated;

    public Session() {
        this.activated = true;
    }

}
