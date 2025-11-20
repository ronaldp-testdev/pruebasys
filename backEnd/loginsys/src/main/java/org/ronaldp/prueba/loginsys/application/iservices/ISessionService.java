package org.ronaldp.prueba.loginsys.application.iservices;

import org.ronaldp.prueba.loginsys.domain.models.entities.Session;

import java.util.Optional;

public interface ISessionService extends ICommonService<Session>{

    Optional<Session> findLastSessionById(Long id);


}
