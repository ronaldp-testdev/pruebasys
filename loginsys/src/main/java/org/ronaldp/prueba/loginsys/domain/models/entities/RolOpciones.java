package org.ronaldp.prueba.loginsys.domain.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name="rol_opciones")
public class RolOpciones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_opcion")
    private String nombreOpcion;

    @Column(name = "id_opcion")
    @JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "roles_rol_opciones",
            joinColumns = {@JoinColumn(name="id_opcion")},
            inverseJoinColumns = {@JoinColumn(name="role_id")},
            uniqueConstraints = {@UniqueConstraint(columnNames = {"id_opcion", "role_id"})}
    )
    private List<Role> roles;

    private boolean activated;

    public RolOpciones() {
        this.roles = new ArrayList<>();
        this.activated = true;
    }
}
