import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * POJO class representing contact entity
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Contact {

    String name;
    String phoneNumber;

    public static Contact createContact(String name, String phoneNumber) {
        return new Contact(name, phoneNumber);
    }

}
