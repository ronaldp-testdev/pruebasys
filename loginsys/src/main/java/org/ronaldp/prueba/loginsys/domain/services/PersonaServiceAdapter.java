package org.ronaldp.prueba.loginsys.domain.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.ronaldp.prueba.loginsys.application.iservices.IPersonaService;
import org.ronaldp.prueba.loginsys.domain.models.entities.Persona;
import org.ronaldp.prueba.loginsys.domain.repositories.IPersonaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

@Service
public class PersonaServiceAdapter extends CommonServiceAdapter<Persona, IPersonaRepository>
        implements IPersonaService {

    @Override
    public void saveCSV(MultipartFile csv) throws JsonProcessingException {
        List<Persona> personaList = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        try (CSVReader csvReader = new CSVReader(new InputStreamReader(csv.getInputStream()))) {
            // Omitir la primera fila (encabezados)
            csvReader.readNext();
            String[] values;
            while ((values = csvReader.readNext()) != null) {
                Persona persona = getPersona(values);
                personaList.add(persona);
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        repository.saveAll(personaList);
    }


    private static Persona getPersona(String[] values) throws ParseException {
        Persona persona = new Persona();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        persona.setNombres(values[0]);
        persona.setApellidos(values[1]);
        persona.setIdentificacion(values[2]);
        persona.setFechaNacimiento(formatter.parse(values[3]));
        return persona;
    }

}