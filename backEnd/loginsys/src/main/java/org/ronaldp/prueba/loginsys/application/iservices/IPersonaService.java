package org.ronaldp.prueba.loginsys.application.iservices;


import com.fasterxml.jackson.core.JsonProcessingException;
import org.ronaldp.prueba.loginsys.domain.models.entities.Persona;
import org.springframework.web.multipart.MultipartFile;

public interface IPersonaService extends ICommonService<Persona> {

    void saveCSV(MultipartFile file) throws JsonProcessingException;

}
