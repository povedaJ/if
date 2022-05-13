package ac.ucr.b96086.persistence.strategy;

import ac.ucr.b96086.persistence.FilePersistence;
import ac.ucr.b96086.persistence.PersistenceEntity;
import ac.ucr.b96086.persistence.Persistence;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;

public class JsonPersistence <E extends PersistenceEntity> extends FilePersistence<E> implements Persistence<E> {

    public JsonPersistence(String root) {
        super(root,"json");
    }



    private ObjectMapper mapper() {
        ObjectMapper mapper = new ObjectMapper();
        // Para convertir LocalDate
        mapper.registerModule(new JavaTimeModule()); // para evitar que falle cuando no encuntre una propiedad en un bean (ya que esta en false )
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);// para no escribir fechas com timetamps
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        return mapper;

    }

    @Override
    protected String convert(PersistenceEntity value) {
        try {
            //return mapper().writeValueAsString(value);

            return mapper().writerWithDefaultPrettyPrinter().writeValueAsString(value);// el metodo extra da formato al json
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override // no me permite el override ya que me pone object en lugar de E  revisar Persistance
    public E save(E value) {
        try {
           storeFile( value);// revisar codigo de profe ya que no necesito poner el casteo
        } catch (IOException e) {
            e.printStackTrace();
        }
        return value;
    }


}
