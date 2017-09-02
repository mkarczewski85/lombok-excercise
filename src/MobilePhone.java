
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@AllArgsConstructor
public class MobilePhone {


    private String myNumber;
    private List<Contact> myContacts;


    /**
     * Metoda dodająca kontakt i zwracjąca true jeśli się udało, false jeśli kontakt istnieje
     */
    public boolean addNewContact(Contact contact) {
        if (findContact(contact) >= 0) {
            log.info("Contact already exist");
            return false;
        } else if (findContact(contact.getName())) {
            log.info("Contact already exist");
            return false;
        }
        myContacts.add(contact);
        return true;
    }

    /**
     * Metoda zwracająca wartość -1 gdy podany kontakt stanowi element w liście kontaków
     *
     * @param contact
     * @return
     */
    public int findContact(Contact contact) {
        return this.myContacts.indexOf(contact);
    }

    /**
     * Metoda zwracająca -1 gdy kontakt o podanej nazwie występuje wśród kontaków ujętych w liście
     *
     * @param name
     * @return
     */
    public boolean findContact(String name) {
        for (int i = 0; i < myContacts.size(); i++) {
            Contact tmpContact = this.myContacts.get(i);
            if (tmpContact.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Metoda aktualizuje kontakt, który istnieje w bazie
     *
     * @param oldContact
     * @param newContact
     * @return
     */
    public boolean updateContact(Contact oldContact, Contact newContact) {
        int contactPosition = findContact(oldContact);
        if (contactPosition < 0) {
            log.info("Contact doesn't exist");
            return false;
        }
        myContacts.set(contactPosition, newContact);
        return true;
    }

    /**
     * Metoda usuwa kontakt, który istnieje w azie
     *
     * @param contact
     * @return
     */
    public boolean removeContact(Contact contact) {
        int contactPosition = findContact(contact);
        if (contactPosition < 0) {
            log.info("Contact doesn't exist");
            return false;
        }
        myContacts.remove(contact);
        return true;
    }

    /**
     * Metoda wyszukuje kontakty o określonej nazwie
     *
     * @param name
     * @return
     */
    public Contact queryContact(String name) {

        for (int i = 0; i < myContacts.size(); i++) {
            Contact tmpContact = this.myContacts.get(i);
            if (tmpContact.getName().equals(name)) {
                return tmpContact;
            }
        }
        return null;
    }

    /**
     * Metoda wyszukuje kontakty po obiekcie.
     *
     * @param contact
     * @return
     */
    public String queryContact(Contact contact) {
        int contactPosition = this.myContacts.indexOf(contact);
        if (contactPosition >= 0) {
            return myContacts.get(contactPosition).getName();
        }
        return null;
    }

    public List<Contact> returnContacts() {
        return myContacts;
    }


}
