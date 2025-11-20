package org.ronaldp.prueba.loginsys.domain.mappers;

import org.mapstruct.Mapper;
import org.ronaldp.prueba.loginsys.domain.models.dtos.RolOpcionesDto;
import org.ronaldp.prueba.loginsys.domain.models.entities.RolOpciones;

@Mapper(componentModel = "spring")
public interface IRolOpcionesMapper extends ICommonMapper<RolOpciones, RolOpcionesDto> {


}
