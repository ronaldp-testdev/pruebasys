package org.ronaldp.prueba.loginsys.domain.services;


import org.ronaldp.prueba.loginsys.application.iservices.ISessionService;
import org.ronaldp.prueba.loginsys.domain.models.entities.Session;
import org.ronaldp.prueba.loginsys.domain.models.entities.User;
import org.ronaldp.prueba.loginsys.domain.repositories.ISessionRepository;
import org.ronaldp.prueba.loginsys.domain.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SessionServiceAdapter extends CommonServiceAdapter<Session, ISessionRepository>
        implements ISessionService {
    @Autowired
    private IUserRepository userRepository;

    @Override
    public Optional<Session> findLastSessionById(Long userId) {
        return repository.findLastSessionByUsuarioId(userId);
    }
}
