package org.ronaldp.prueba.loginsys.domain.models.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    private boolean activated;

    public Role() {
        this.activated = true;
    }
    //Constructor vacio
}
