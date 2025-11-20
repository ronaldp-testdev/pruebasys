package org.ronaldp.prueba.loginsys.domain.repositories;

import io.jsonwebtoken.security.Jwks;
import org.ronaldp.prueba.loginsys.domain.models.entities.Session;
import org.ronaldp.prueba.loginsys.domain.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ISessionRepository extends JpaRepository<Session, Long> {

    @Query("select s from Session s where s.usuario.id = ?1 and s.fechaIngreso = (select max(s2.fechaIngreso) from Session s2 where s2.usuario.id = ?1)")
    Optional<Session> findLastSessionByUsuarioId(Long userId);



}
