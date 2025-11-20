package org.ronaldp.prueba.loginsys.domain.services;

import org.ronaldp.prueba.loginsys.application.iservices.IRolOpcionesService;
import org.ronaldp.prueba.loginsys.application.iservices.IRolService;
import org.ronaldp.prueba.loginsys.domain.models.entities.RolOpciones;
import org.ronaldp.prueba.loginsys.domain.models.entities.Role;
import org.ronaldp.prueba.loginsys.domain.repositories.IRolOpcionesRepository;
import org.ronaldp.prueba.loginsys.domain.repositories.IRoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceAdapter extends CommonServiceAdapter<Role, IRoleRepository>
        implements IRolService {
}
