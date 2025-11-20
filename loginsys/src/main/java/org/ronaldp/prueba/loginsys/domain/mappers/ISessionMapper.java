package org.ronaldp.prueba.loginsys.domain.mappers;

import org.mapstruct.Mapper;
import org.ronaldp.prueba.loginsys.domain.models.dtos.SessionDto;
import org.ronaldp.prueba.loginsys.domain.models.entities.Session;

@Mapper(componentModel = "spring")
public interface ISessionMapper extends ICommonMapper<Session, SessionDto> {
}
