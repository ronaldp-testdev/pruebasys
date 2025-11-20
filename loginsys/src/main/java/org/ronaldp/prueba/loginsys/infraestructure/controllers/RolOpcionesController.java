package org.ronaldp.prueba.loginsys.infraestructure.controllers;

import jakarta.validation.Valid;
import org.ronaldp.prueba.loginsys.application.iservices.IRolOpcionesService;
import org.ronaldp.prueba.loginsys.domain.mappers.IRolOpcionesMapper;
import org.ronaldp.prueba.loginsys.domain.mappers.IRoleMapper;
import org.ronaldp.prueba.loginsys.domain.models.dtos.RolOpcionesDto;
import org.ronaldp.prueba.loginsys.domain.models.entities.RolOpciones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/rol-opciones")
public class RolOpcionesController extends CommonController<RolOpciones, IRolOpcionesService,
        RolOpcionesDto, IRolOpcionesMapper>{

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@Valid @RequestBody RolOpcionesDto rolOpcionesDto, BindingResult result,
                                    @PathVariable Long id){
        //Validacion
        if(result.hasErrors()){
            return this.validar(result);
        }
        Optional<RolOpciones> o = service.findById(id);
        if(o.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        RolOpciones rolOpcionesDb = o.get();
        rolOpcionesDb.setNombreOpcion(rolOpcionesDto.getNombreOpcion());
        //
//        List<Role> roles = rolOpcionesDto.getRoles().stream()
//                .map(m -> roleMapper.toEntity(m))
//                .toList();
//        rolOpcionesDb.setRoles(roles);
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.todto(service.save(rolOpcionesDb)));


    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        Optional<RolOpciones> o = service.findById(id);
        if(o.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        RolOpciones rolOpcionesDb = o.get();
        rolOpcionesDb.setActivated(!rolOpcionesDb.isActivated());
        return ResponseEntity.status(HttpStatus.OK).body(mapper.todto(service.save(rolOpcionesDb)));
    }

}
