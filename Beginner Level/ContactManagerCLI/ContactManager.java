import java.util.ArrayList;
import java.util.Scanner;

class Contact 
{
    String name, phone, email;

    Contact(String name, String phone, String email) 
    {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public String toString() 
    {
        return "Name: " + name + ", Phone: " + phone + ", Email: " + email;
    }
}

public class ContactManager 
{
    static ArrayList<Contact> contacts = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) 
    {
        int choice;
        do 
        {
            System.out.println("\n--- Contact Management System ---");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Update Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            switch (choice) 
            {
                case 1: addContact(); break;
                case 2: viewContacts(); break;
                case 3: updateContact(); break;
                case 4: deleteContact(); break;
                case 5: System.out.println("Exiting..."); break;
                default: System.out.println("Invalid choice.");
            }
        } while (choice != 5);
    }

    static void addContact() 
    {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter phone: ");
        String phone = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        contacts.add(new Contact(name, phone, email));
        System.out.println("Contact added.");
    }

    static void viewContacts() 
    {
        if (contacts.isEmpty()) 
        {
            System.out.println("No contacts found.");
            return;
        }
        for (int i = 0; i < contacts.size(); i++) 
        {
            System.out.println((i+1) + ". " + contacts.get(i));
        }
    }

    static void updateContact() 
    {
        viewContacts();
        System.out.print("Enter contact number to update: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine(); // clear buffer
        if (index >= 0 && index < contacts.size()) 
        {
            System.out.print("Enter new name: ");
            contacts.get(index).name = scanner.nextLine();
            System.out.print("Enter new phone: ");
            contacts.get(index).phone = scanner.nextLine();
            System.out.print("Enter new email: ");
            contacts.get(index).email = scanner.nextLine();
            System.out.println("Contact updated.");
        } 
        else 
        {
            System.out.println("Invalid contact number.");
        }
    }

    static void deleteContact() 
    {
        viewContacts();
        System.out.print("Enter contact number to delete: ");
        int index = scanner.nextInt() - 1;
        if (index >= 0 && index < contacts.size()) 
        {
            contacts.remove(index);
            System.out.println("Contact deleted.");
        } 
        else 
        {
            System.out.println("Invalid contact number.");
        }
    }
}
