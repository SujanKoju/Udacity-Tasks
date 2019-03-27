package ContactApp;

import ContactApp.ContactManager;

import java.util.Scanner;

public class Main {
    public static void main(String []args) {
        ContactManager myContactManager = new ContactManager();
        Contact sujan = new Contact("Sujan", "kojusujan@gmail.com", "9841049648");
        Contact sagar = new Contact("Sagar", "bksagar@gmail.com", "9841047788");
        Contact anish = new Contact("Anish", "mallaanish@gmail.com", "9841546788");
        Contact sandesh = new Contact("Sandesh", "sandesh@gmail.com", "9841045566");

        myContactManager.addContact(sujan);
        myContactManager.addContact(sagar);
        myContactManager.addContact(anish);
        myContactManager.addContact(sandesh);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Name to Search in Contact List");
        String contactToSearch = scanner.nextLine();
        Contact searchedContact = new Contact();
        try {
            searchedContact = myContactManager.searchContact(contactToSearch);
            System.out.println(contactToSearch + "," + "P.N-> " + searchedContact.phoneNumber);
        } catch (NullPointerException e) {

            System.out.println("NO Contact found with name :" + contactToSearch);
        }


    }


}
