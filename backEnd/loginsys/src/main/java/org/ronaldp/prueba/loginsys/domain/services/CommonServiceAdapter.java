package org.ronaldp.prueba.loginsys.domain.services;

import org.ronaldp.prueba.loginsys.application.iservices.ICommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public class CommonServiceAdapter <E, R extends JpaRepository<E, Long>> implements ICommonService<E> {
    @Autowired
    protected R repository;

    @Override
    @Transactional(readOnly = true)
    public Iterable<E> findAll() {
        return repository.findAll();
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<E> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public E save(E entity) {
        return repository.save(entity);
    }



    @Override
    @Transactional(readOnly = true)
    public Page<E> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

//    @Override
//    @Transactional
//    public void deleteById(Long id) {
//        repository.deleteById(id);
//
//    }
}
