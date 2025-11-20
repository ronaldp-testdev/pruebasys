package org.ronaldp.prueba.loginsys.domain.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.ronaldp.prueba.loginsys.domain.models.dtos.UserDto;
import org.ronaldp.prueba.loginsys.domain.models.entities.User;

@Mapper(componentModel = "spring")
public interface IUserMapper extends ICommonMapper<User, UserDto> {

    @Override
    @Mapping(target = "user.password", ignore = true)
    UserDto todto(User entity);

}
