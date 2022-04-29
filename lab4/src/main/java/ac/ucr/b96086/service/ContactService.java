package ac.ucr.b96086.service;

import ac.ucr.b96086.domain.Contact;
import ac.ucr.b96086.persistence.Persistence;
import ac.ucr.b96086.persistence.PersistenceContext;

public class ContactService {

private final Persistence<Contact> persistance= PersistenceContext.getInstance().getPersistenceInstance();


    public void  save (Contact contact){
        // validar inputs
        // retorna algun tipo de valor diferente o lanzando una exception
        // ejemplo = agregar regla de negocio ejemplo limitar la edad ,. es decir menores de 18 no pueden guardarse como contactos
        persistance.save(contact);
    }


}// class que va a conectarse con el javafx
