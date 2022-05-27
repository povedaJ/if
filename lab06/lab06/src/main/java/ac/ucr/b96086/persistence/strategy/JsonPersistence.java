/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.ucr.b96086.persistence.strategy;

import ac.ucr.b96086.persistence.FilePersistence;
import ac.ucr.b96086.persistence.Persistence;
import ac.ucr.b96086.persistence.PersistenceEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;

/**
 *
 * @author Gerson Cordero 
 */
public class JsonPersistence<E extends PersistenceEntity>
        extends FilePersistence<E>
       {
    public JsonPersistence(String root, Class<E> clazz) {
        super(root, "json", clazz);
    }

    @Override
    protected String convert(E value) {
        try {
            // No formatea el JSON
            //return mapper().writeValueAsString(value);
            //Formatea el JSON
            return mapper().writerWithDefaultPrettyPrinter().writeValueAsString(value);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

           @Override
           public E toEntity(String content) {

               try {
                   return mapper().readValue(content,clazz);
               }catch (JsonProcessingException e){
                   e.printStackTrace();
                   throw new RuntimeException(e);
               }
           }

           private ObjectMapper mapper() {
        ObjectMapper mapper = new ObjectMapper();
        // Para poder convertir LocalDate
        mapper.registerModule(new JavaTimeModule());
        // Para evitar que falle cuando no encuentre una propiedad en un bean
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        // Para no escribir fechas como timestamps
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        return mapper;

    }


    public E save(E value) {
        try {
            storeFile(value);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return value;
    }
}
