package org.ronaldp.prueba.loginsys.domain.mappers;


import org.mapstruct.Mapper;
import org.ronaldp.prueba.loginsys.domain.models.dtos.PersonaDto;
import org.ronaldp.prueba.loginsys.domain.models.entities.Persona;

@Mapper(componentModel = "spring")
public interface IPersonaMapper extends ICommonMapper<Persona, PersonaDto>{
}
