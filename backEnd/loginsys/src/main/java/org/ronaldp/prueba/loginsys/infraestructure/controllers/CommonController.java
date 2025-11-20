package org.ronaldp.prueba.loginsys.infraestructure.controllers;

import jakarta.validation.Valid;
import org.ronaldp.prueba.loginsys.application.iservices.ICommonService;
import org.ronaldp.prueba.loginsys.domain.mappers.ICommonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class CommonController <E, S extends ICommonService<E>,  D, M extends ICommonMapper<E, D>>{
    @Autowired
    protected S service;

    @Autowired
    protected M mapper;

    @GetMapping
    public ResponseEntity<?> listar(){
        //return ResponseEntity.ok().body(service.findAll().forEach(m-> mapper.convert(m)));
        List<E> entities =  (List<E>) service.findAll();
        List<D> dtos = entities.stream()
                .map(m -> mapper.todto(m))
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(dtos);
    }

    //Ej: localhost:8090/api/alumnos/pagina?page=0&size=5
    @GetMapping("/pagina")
    public ResponseEntity<?> listar(Pageable pageable){
        //return ResponseEntity.ok().body(service.findAll(pageable));
        Page<D> pageDto = service.findAll(pageable).map(m -> mapper.todto(m));
        return ResponseEntity.ok().body(pageDto);
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> ver(@PathVariable Long id){
        Optional<E> o = service.findById(id);
        if(o.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        //return ResponseEntity.ok(o.get());
        return ResponseEntity.ok(mapper.todto(o.get()));

    }



    @PostMapping
    public ResponseEntity<?> crear(@Valid @RequestBody D dto, BindingResult result){ //Binding siempre va segundo
        if(result.hasErrors()){
            return this.validar(result);
        }
        E entityDb = service.save(mapper.toEntity(dto));
        return ResponseEntity.status(HttpStatus.CREATED).body(entityDb);
    }



    protected ResponseEntity<?> validar(BindingResult result){
        Map<String, Object> errores = new HashMap<>();
        result.getFieldErrors().forEach(err -> {
            errores.put(err.getField(), "El campo " + err.getField() + " " + err.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errores);
    }


//    @DeleteMapping("/{id}")
//    public ResponseEntity<?> eliminar(@PathVariable Long id){
//        service.deleteById(id);
//        return ResponseEntity.noContent().build();
//    }
}
