package org.ronaldp.prueba.loginsys.application.iservices;


import org.ronaldp.prueba.loginsys.domain.models.dtos.UserRequest;
import org.ronaldp.prueba.loginsys.domain.models.entities.User;

import java.util.Optional;

public interface IUserService extends ICommonService<User>{
    //Update
    Optional<User> update(UserRequest user, Long id);
}
