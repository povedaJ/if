package ac.ucr.b96086;

import ac.ucr.b96086.domain.Contact;
import ac.ucr.b96086.persistence.PersistenceContext;
import ac.ucr.b96086.persistence.PersistenceStrategy;
import ac.ucr.b96086.service.ContactService;

import java.time.LocalDate;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {

        PersistenceContext.getInstance().setRoot("c:/data");
        PersistenceContext.getInstance().setStrategy(PersistenceStrategy.JSON);
        ContactService service = new ContactService();

        Contact c = new Contact();

        c.setBrithday(LocalDate.now());
        c.setName("Miguel");
        c.setSurname("De Cervantes ");
        service.save(c);
    }
}
