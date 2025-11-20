package org.ronaldp.prueba.loginsys.domain.repositories;

import org.ronaldp.prueba.loginsys.domain.models.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<User, Long> {
    //Método para paginación - de springframework
    Page<User> findAll(Pageable pageable);

    //Para Login
    Optional<User> findByUsername(String name);
}
