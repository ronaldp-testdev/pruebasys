package org.ronaldp.prueba.loginsys.domain.services;

import org.ronaldp.prueba.loginsys.application.iservices.ICommonService;
import org.ronaldp.prueba.loginsys.application.iservices.IPersonaService;
import org.ronaldp.prueba.loginsys.application.iservices.IRolOpcionesService;
import org.ronaldp.prueba.loginsys.domain.models.entities.Persona;
import org.ronaldp.prueba.loginsys.domain.models.entities.RolOpciones;
import org.ronaldp.prueba.loginsys.domain.repositories.IPersonaRepository;
import org.ronaldp.prueba.loginsys.domain.repositories.IRolOpcionesRepository;
import org.springframework.stereotype.Service;

@Service
public class RolOpcionesServiceAdapter  extends CommonServiceAdapter<RolOpciones, IRolOpcionesRepository>
        implements IRolOpcionesService {
}
