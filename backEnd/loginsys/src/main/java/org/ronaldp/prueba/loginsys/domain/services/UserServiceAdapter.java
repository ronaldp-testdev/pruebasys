package org.ronaldp.prueba.loginsys.domain.services;

import org.ronaldp.prueba.loginsys.application.iservices.IUserService;
import org.ronaldp.prueba.loginsys.domain.models.dtos.IUser;
import org.ronaldp.prueba.loginsys.domain.models.dtos.UserDto;
import org.ronaldp.prueba.loginsys.domain.models.dtos.UserRequest;
import org.ronaldp.prueba.loginsys.domain.models.entities.Persona;
import org.ronaldp.prueba.loginsys.domain.models.entities.Role;
import org.ronaldp.prueba.loginsys.domain.models.entities.User;
import org.ronaldp.prueba.loginsys.domain.repositories.IPersonaRepository;
import org.ronaldp.prueba.loginsys.domain.repositories.IRoleRepository;
import org.ronaldp.prueba.loginsys.domain.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceAdapter extends CommonServiceAdapter<User, IUserRepository>
        implements IUserService {

    @Autowired
    private IRoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;



    //CREATE
    @Transactional
    @Override
    public User save(User user) {
        user.setRoles(getRoles(user));
        //user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEmail("xyz@mail.com");
        user.setPassword(passwordEncoder.encode("12345"));
        return repository.save(user);
    }


    @Transactional
    public Optional<User> update(UserRequest user, Long id) {
        Optional<User> userOptional = repository.findById(id);
        if(userOptional.isPresent()){
            User userDb = userOptional.get();
            //userDb.setEmail(user.getEmail());

            userDb.setUsername(user.getUsername());

            //Roles
            userDb.setRoles(getRoles(user));
            return Optional.of(repository.save(userDb));
        }
        return Optional.empty();
    }

//    @Transactional
//    @Override
//    public void deleteById(Long id) {
//        repository.deleteById(id);
//    }

    private List<Role> getRoles(IUser user) {
        List<Role> roles = new ArrayList<>();
        Optional<Role> optionalRoleUser = roleRepository.findByName("ROLE_USER");
        //optionalRoleUser.ifPresent(role -> roles.add(role));
        optionalRoleUser.ifPresent(roles::add);
        if (user.isAdmin()) {
            Optional<Role> optionalRoleAdmin = roleRepository.findByName("ROLE_ADMIN");
            optionalRoleAdmin.ifPresent(roles::add);
        }
        return roles;
    }
}
