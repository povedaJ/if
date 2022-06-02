package ac.ucr.b96086;

import ac.ucr.b96086.domain.Contact;
import ac.ucr.b96086.persistence.PersistenceContext;
import ac.ucr.b96086.persistence.PersistenceStrategy;
import ac.ucr.b96086.service.ContactService;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args)  {
        try {
            PersistenceContext.getInstance().setRoot(new File("data").getCanonicalPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        PersistenceContext.getInstance().setStrategy(PersistenceStrategy.XML);

        ContactService service = new ContactService();

        Contact c = new Contact();
        c.setBirthdate(LocalDate.now());
        c.setName("Miguel");
        c.setSurname("De Cervantes");
        service.save(c);
   List<Contact> contacts=  service.findAll();
   System.out.println(contacts);
   contacts.forEach(System.out::println);
    }
}
