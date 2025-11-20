package org.ronaldp.prueba.loginsys.infraestructure.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.validation.Valid;
import org.ronaldp.prueba.loginsys.application.iservices.IPersonaService;
import org.ronaldp.prueba.loginsys.domain.mappers.IPersonaMapper;
import org.ronaldp.prueba.loginsys.domain.models.dtos.PersonaDto;
import org.ronaldp.prueba.loginsys.domain.models.entities.Persona;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@RestController
@RequestMapping("/api/personas")
public class PersonaController extends CommonController<Persona, IPersonaService,
        PersonaDto, IPersonaMapper>{


    @PostMapping("/csv")
    public ResponseEntity<?> csv(@RequestParam MultipartFile csv) throws JsonProcessingException {
        if(csv.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        service.saveCSV(csv);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@Valid @RequestBody PersonaDto personaDto, BindingResult result,
                                    @PathVariable Long id){
        //Validacion
        if(result.hasErrors()){
            return this.validar(result);
        }
        Optional<Persona> o = service.findById(id);
        if(o.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        Persona personaDb = o.get();
        personaDb.setNombres(personaDto.getNombres());
        personaDb.setApellidos(personaDto.getApellidos());
        personaDb.setIdentificacion(personaDto.getIdentificacion());
        personaDb.setFechaNacimiento(personaDto.getFechaNacimiento());
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.todto(service.save(personaDb)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        Optional<Persona> o = service.findById(id);
        if(o.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        Persona personaDb = o.get();
        personaDb.setActivated(!personaDb.isActivated());
        return ResponseEntity.status(HttpStatus.OK).body(mapper.todto(service.save(personaDb)));
    }
}
