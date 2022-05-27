package ac.ucr.b96086.service;

import ac.ucr.b96086.domain.Contact;
import ac.ucr.b96086.persistence.Persistence;
import ac.ucr.b96086.persistence.PersistenceContext;

import java.util.List;

public class ContactService {

    private final Persistence<Contact> persistence = PersistenceContext
            .getInstance()
            .getPersistenceInstance(Contact.class);

    public void save(Contact contact) {
        // validar inputs  ->
        // retornando algún tipo de valor diferente o lanzando una excepcion personalizada
        persistence.save(contact);
    }

    public List<Contact> findAll() {
        return persistence.findAll();
    }
}
