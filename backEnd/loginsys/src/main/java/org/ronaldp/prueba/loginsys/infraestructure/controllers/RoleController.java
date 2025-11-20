package org.ronaldp.prueba.loginsys.infraestructure.controllers;

import jakarta.validation.Valid;
import org.ronaldp.prueba.loginsys.application.iservices.IRolService;
import org.ronaldp.prueba.loginsys.domain.mappers.IRoleMapper;
import org.ronaldp.prueba.loginsys.domain.models.dtos.RoleDto;
import org.ronaldp.prueba.loginsys.domain.models.entities.Role;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/roles")
public class RoleController extends CommonController<Role, IRolService,
        RoleDto, IRoleMapper>{

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@Valid @RequestBody RoleDto roleDto, BindingResult result,
                                    @PathVariable Long id){
        //Validacion
        if(result.hasErrors()){
            return this.validar(result);
        }
        Optional<Role> o = service.findById(id);
        if(o.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        Role roleDb = o.get();
        roleDb.setName(roleDto.getName());
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.todto(service.save(roleDb)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        Optional<Role> o = service.findById(id);
        if(o.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        Role roleDb = o.get();
        roleDb.setActivated(!roleDb.isActivated());
        return ResponseEntity.status(HttpStatus.OK).body(mapper.todto(service.save(roleDb)));
    }
}
