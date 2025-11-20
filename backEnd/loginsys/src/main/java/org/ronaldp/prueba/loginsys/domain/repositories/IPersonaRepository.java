package org.ronaldp.prueba.loginsys.domain.repositories;

import org.ronaldp.prueba.loginsys.domain.models.entities.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPersonaRepository extends JpaRepository<Persona, Long> {
}
