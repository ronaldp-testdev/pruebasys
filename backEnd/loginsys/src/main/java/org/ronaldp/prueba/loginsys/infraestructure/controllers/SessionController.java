package org.ronaldp.prueba.loginsys.infraestructure.controllers;

import jakarta.validation.Valid;
import org.ronaldp.prueba.loginsys.application.iservices.IRolService;
import org.ronaldp.prueba.loginsys.application.iservices.ISessionService;
import org.ronaldp.prueba.loginsys.domain.mappers.IRoleMapper;
import org.ronaldp.prueba.loginsys.domain.mappers.ISessionMapper;
import org.ronaldp.prueba.loginsys.domain.models.dtos.RolOpcionesDto;
import org.ronaldp.prueba.loginsys.domain.models.dtos.RoleDto;
import org.ronaldp.prueba.loginsys.domain.models.dtos.SessionDto;
import org.ronaldp.prueba.loginsys.domain.models.entities.RolOpciones;
import org.ronaldp.prueba.loginsys.domain.models.entities.Role;
import org.ronaldp.prueba.loginsys.domain.models.entities.Session;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/sessions")
public class SessionController extends CommonController<Session, ISessionService,
        SessionDto, ISessionMapper>{


    @GetMapping("/ultima/{userid}")
    public ResponseEntity<?> ultimaSession(@PathVariable Long userid){
        Optional<Session> o = service.findLastSessionById(userid);
        if(o.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(mapper.todto(o.get()));

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@Valid @RequestBody SessionDto sessionDto, BindingResult result,
                                    @PathVariable Long id){
        //Validacion
        if(result.hasErrors()){
            return this.validar(result);
        }
        Optional<Session> o = service.findById(id);
        if(o.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        Session sessionDb = o.get();
        //sessionDb.setIdusuario(sessionDto.getIdusuario());
        sessionDb.setFechaIngreso(sessionDto.getFechaIngreso());
        sessionDb.setFechaCierre(sessionDto.getFechaCierre());

        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.todto(service.save(sessionDb)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        Optional<Session> o = service.findById(id);
        if(o.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        Session sessionDb = o.get();
        sessionDb.setActivated(!sessionDb.isActivated());
        return ResponseEntity.status(HttpStatus.OK).body(mapper.todto(service.save(sessionDb)));
    }
}
