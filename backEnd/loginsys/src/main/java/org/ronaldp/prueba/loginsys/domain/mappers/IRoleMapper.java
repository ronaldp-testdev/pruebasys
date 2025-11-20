package org.ronaldp.prueba.loginsys.domain.mappers;

import org.mapstruct.Mapper;
import org.ronaldp.prueba.loginsys.domain.models.dtos.RoleDto;
import org.ronaldp.prueba.loginsys.domain.models.entities.Role;

@Mapper(componentModel = "spring")
public interface IRoleMapper extends ICommonMapper<Role, RoleDto> {
}
