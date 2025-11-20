package org.ronaldp.prueba.loginsys.infraestructure.controllers;

import jakarta.validation.Valid;

import org.ronaldp.prueba.loginsys.application.iservices.IUserService;

import org.ronaldp.prueba.loginsys.domain.mappers.IUserMapper;

import org.ronaldp.prueba.loginsys.domain.models.dtos.UserDto;
import org.ronaldp.prueba.loginsys.domain.models.dtos.UserRequest;
import org.ronaldp.prueba.loginsys.domain.models.entities.Session;
import org.ronaldp.prueba.loginsys.domain.models.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/usuarios")
public class UserController extends CommonController<User, IUserService,
        UserDto, IUserMapper>{


    @PutMapping("/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody UserRequest user, BindingResult result, @PathVariable Long id){
        //Validaciones
        if(result.hasErrors()){
            return validation(result);
        }
        Optional<User> userOptional = service.update(user, id);
        if(userOptional.isPresent()){
            return ResponseEntity.ok(userOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        Optional<User> o = service.findById(id);
        if(o.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        User userDb = o.get();
        userDb.setActivated(!userDb.isActivated());
        return ResponseEntity.status(HttpStatus.OK).body(mapper.todto(service.save(userDb)));
    }

    private ResponseEntity<?> validation(BindingResult result) {
        Map<String, String > errors = new HashMap<>();
        result.getFieldErrors().forEach(error ->{
            errors.put(error.getField(),"El campo "+ error.getField() + " " + error.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errors);
    }

}
