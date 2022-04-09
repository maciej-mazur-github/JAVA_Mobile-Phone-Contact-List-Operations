import java.util.ArrayList;
import java.util.Scanner;

public class MobilePhone {
    private ArrayList<Contact> contactList;
    private String myPhoneNumber;
    private final Scanner scanner = new Scanner(System.in);

    public MobilePhone(String myPhoneNumber) {
        this.contactList = new ArrayList<>();
        this.myPhoneNumber = myPhoneNumber;
    }

    private boolean addNewContact(Contact contact) {
        if(findContact(contact) < 0) {
            contactList.add(contact);
            return true;
        } else {
            return false;
        }
    }

    private boolean addNewContact(String name, String phoneNumber) {
        Contact contact = Contact.createNewContact(name, phoneNumber);
        return addNewContact(contact);
    }

    private void addNewContact() {
        System.out.print("Enter the name: ");
        String name = scanner.nextLine();
        System.out.print("Enter the phone number: ");
        String phoneNumber = scanner.nextLine();

        if (phoneNumber.equals(myPhoneNumber)) {
            System.out.println("You can't add a contact containing your own phone number");
            return;
        }

        if(addNewContact(name, phoneNumber)) {
            System.out.println("New contact (" + name + ", " + phoneNumber + ") successfully added");
        } else {
            System.out.println("The contact (" + name + ", " + phoneNumber + ") already exists your contact list. Operation failed.");
        }
    }

    private void updateContact(Contact currentContact, Contact newContact) {
        int position = contactList.indexOf(currentContact);
        contactList.set(position, newContact);
    }

    private void updateContact() {
        System.out.print("Enter the contact name that you need to modify: ");
        String existingName = scanner.nextLine();
        Contact existingContact = queryContact(existingName);

        if(existingContact == null) {
            System.out.println("There is no contact " + existingName + " in your contact list");
            return;
        }

        String existingPhoneNumber = existingContact.getPhoneNumber();
        System.out.println();
        System.out.print("Enter the new contact name: ");
        String newName = scanner.nextLine();
        System.out.print("Enter the new phone number: ");
        String newPhoneNumber = scanner.nextLine();
        Contact newContact = Contact.createNewContact(newName, newPhoneNumber);
        updateContact(existingContact, newContact);
        System.out.println("The old contact (" + existingName + ", " + existingPhoneNumber + ") has been successfully updated to (" +
                newName + ", " + newPhoneNumber + ")");
    }


    private void removeContact(Contact contact) {
        contactList.remove(contact);
    }

    private void removeContact() {
        System.out.print("Enter the contact name that you need to delete: ");
        String existingName = scanner.nextLine();
        Contact existingContact = queryContact(existingName);

        if(existingContact == null) {
            System.out.println("There is no contact " + existingName + " in your contact list");
            return;
        }

        String existingPhoneNumber = existingContact.getPhoneNumber();
        removeContact(existingContact);
        System.out.println("The contact (" + existingName + ", " + existingPhoneNumber + ") has been successfully deleted");
    }

    private int findContact(Contact contact) {
        return contactList.indexOf(contact);
    }

    private int findContact(String name) {
        for (int i = 0; i < contactList.size(); i++) {
            if (contactList.get(i).getName().equals(name)) {
                return i;
            }
        }

        return -1;
    }

    private Contact queryContact(String name) {
        int position = findContact(name);

        if(position >= 0) {
            return contactList.get(position);
        } else {
            return null;
        }
    }

    private void printActions() {
        System.out.println("\nPress:");
        System.out.println("\t0 - to print available choice list");
        System.out.println("\t1 - to print the current Contact List content");
        System.out.println("\t2 - to add a new contact");
        System.out.println("\t3 - to modify the existing contact");
        System.out.println("\t4 - to delete the existing contact");
        System.out.println("\t5 - to search for an existing contact");
        System.out.println("\t6 - to quit the program");
    }



    public void runMobilePhone() {
        System.out.println("\nWelcome to Mobile Phone contact list operations simulation program. Your phone number is " + myPhoneNumber);
        System.out.println("**********************************");
        printActions();
        boolean quit = false;
        int choice;

        while (!quit) {
            System.out.print("What action do you choose? ");
            choice = scanner.nextInt();

            if(choice < 0 || choice > 6) {
                System.out.println("Invalid choice number. Try again...");
                continue;
            }

            switch (choice) {
                case 0:
                    printActions();
                    break;
                case 1:

            }
        }
    }
}
