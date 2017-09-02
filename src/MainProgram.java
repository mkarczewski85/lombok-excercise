import lombok.experimental.var;

import java.util.ArrayList;
import java.util.Scanner;


public class MainProgram {

    public static Scanner scanner = new Scanner(System.in);
    public static MobilePhone mobilePhone = new MobilePhone("666 999 111", new ArrayList<>());

    public static void main(String[] args) {
        var quit = false;
        while (!quit) {
            showOptions();
            System.out.print("Wybierz opcję: ");
            var action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0: {
                    System.out.println("Zakończenie programu");
                    quit = true;
                    break;
                }

                case 1:
                    printContacts();
                    break;

                case 2:
                    addNewContact();
                    break;

                case 3:
                    updateContact();
                    break;

                case 4:
                    removeContact();
                    break;

                case 5:
                    queryContact();
                    break;
            }

        }
    }

    private static void queryContact() {
        System.out.print("Podaj nazwę kontaktu, którego szukasz: ");
        var name = scanner.nextLine();
        var seekingContact = mobilePhone.queryContact(name);
        if (seekingContact == null) {
            System.out.println("Nie znaleziono kontaktu o podanej nazwie");
            return;
        }
        var id = mobilePhone.returnContacts().indexOf(seekingContact);
        System.out.println("Odnaleziono kontakt: ");
        System.out.println((id + 1) + ". imie: " + seekingContact.getName() + ", nr tel.: " + seekingContact.getPhoneNumber());

    }

    private static void removeContact() {
        System.out.print("Podaj nazwę kontaktu do usunięcia: ");
        var name = scanner.nextLine();
        var existingContact = mobilePhone.queryContact(name);
        if (existingContact == null) {
            System.out.println("Nie znaleziono kontaktu o podanej nazwie");
            return;
        }

        if (mobilePhone.removeContact(existingContact)) {
            System.out.println("Kontakt został usunięty");
        } else {
            System.out.println("Wystąpił błąd");
        }
    }

    private static void updateContact() {
        System.out.print("Podaj imię: ");
        var name = scanner.nextLine();
        var existingContact = mobilePhone.queryContact(name);
        if (existingContact == null) {
            System.out.println("Nie znaleziono kontaktu o podanej nazwie");
            return;
        }
        System.out.print("Podaj nowe imię: ");
        var newName = scanner.nextLine();
        System.out.print("Podaj nowy numer telefonu: ");
        var newNumber = scanner.nextLine();
        var newContact = Contact.createContact(newName, newNumber);
        if (mobilePhone.updateContact(existingContact, newContact)) {
            System.out.println("Kontakt został zaktualizowany");
        } else {
            System.out.println("Wystąpił błąd");
        }
    }

    private static void addNewContact() {
        System.out.print("Podaj imię: ");
        var name = scanner.nextLine();
        System.out.print("Podaj nr telefonu: ");
        var phone = scanner.nextLine();
        var newContact = Contact.createContact(name, phone);
        if (mobilePhone.addNewContact(newContact)) {
            System.out.println("Dodano nowy kontakt: " + name + ", tel.: " + phone);
        } else {
            System.out.println("Kontakt o nazwie" + name + " już istnieje");
        }
    }

    private static void printContacts() {
        var id = 0;
        for (Contact contact : mobilePhone.returnContacts()) {
            id = mobilePhone.returnContacts().indexOf(contact);
            System.out.println((id + 1) + ". Imię: " + contact.getName() + ", tel.: " + contact.getPhoneNumber());
        }
    }

    private static void showOptions() {
        System.out.println("+-----------------------------------+");
        System.out.println("| 1. Pokaż wszystkie kontakty       |");
        System.out.println("| 2. Dodaj nowy kontakt             |");
        System.out.println("| 3. Uaktualnij kontakt             |");
        System.out.println("| 4. Usuń kontakt                   |");
        System.out.println("| 0. Zakończ program                |");
        System.out.println("+-----------------------------------+");
    }

}

