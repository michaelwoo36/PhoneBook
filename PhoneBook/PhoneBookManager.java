package PhoneBook;

import java.util.Scanner;

public class PhoneBookManager {

    // Always first node in LinkedList.
    public LinkNode front;

    public Scanner input;

    public String name;
    public String phone;
    public String address;
    public String city;

    public PhoneBookManager(Scanner input) {

        this.input = input;
        front = null;
    }

    // Menu for user input.
    public void ask(){

        System.out.println("add contact (a)");
        System.out.println("remove contact (r)");
        System.out.println("change contact (c)");
        System.out.println("Display phone book (d)");
        System.out.println("Close phone book (e)");
    }

    // Asks user for contact.
    public void whichOne(){

        System.out.println("Name");
        input.nextLine();
        name = input.nextLine();

        System.out.println("Phone");
        phone = input.nextLine();

        System.out.println("address");
        address = input.nextLine();

        System.out.println("city");
        city = input.nextLine();
    }

    // Prints out one contact.
    public void showContact(LinkNode current){

        System.out.println();

        System.out.println("Name: " + current.name);
        System.out.println("Phone: " + current.phone);
        System.out.println("Address: " + current.address);
        System.out.println("City: " + current.city);

        System.out.println();
    }

    // Adds contact to Phone Book.
    public void add() {

        whichOne();

        LinkNode temp = front;
        LinkNode added;

        if(front == null){

            front = new LinkNode(name, phone, address, city);
            added = front;
        }

        else{

            while(temp.next != null){
                temp = temp.next;
            }

            temp.next = new LinkNode(name, phone, address, city);
            added = temp.next;

        }

        System.out.println();
        System.out.println("added contact:");

        showContact(added);

    }

    // Removes specified contact from phone book.
    public void remove(){

        System.out.println("Type name, phone, address, and city of contact you want to remove");

        whichOne();

        try {

            LinkNode current = front;
            LinkNode prev = null;

            // If first node in LinkedList contains specified element
            if (current.name.equalsIgnoreCase(name) && current.phone.equalsIgnoreCase(phone) && current.address.equalsIgnoreCase(address) && current.city.equalsIgnoreCase(city)) {

                front = current.next;
                return;
            }

            // Searches until it reaches specified contact element.
            while (current != null && (!(current.name.equalsIgnoreCase(name)) || !(current.phone.equalsIgnoreCase(phone)) || !(current.address.equalsIgnoreCase(address)) || !(current.city.equalsIgnoreCase(city)))) {

                prev = current;
                current = current.next;
            }

            prev.next = current.next;
            System.out.println();
            System.out.println("Contact removed.");
        }

        catch (NullPointerException nullPoint){

            System.out.println();
            System.out.println("The contact you wish to remove does not exist");
            System.out.println();
        }
    }

    // Changes specified element from specified contact.
    public void change(){

        System.out.println("Type name, phone, address, and city of contact you want to change");

        whichOne();

        try {

            System.out.println("What do you want to change");
            System.out.println("name (n), phone (p), address (a), or city (c)");

            String ans = input.next();

            LinkNode current = front;

            while (current != null && (!(current.name.equals(name)) || !(current.phone.equals(phone)) || !(current.address.equals(address)) || !(current.city.equals(city)))) {

                current = current.next;
            }
            switch (ans) {

                case "n":

                    System.out.println("What would you like to change it to");
                    input.nextLine();
                    ans = input.nextLine();

                    if (current.name.equals(name) && current.phone.equals(phone) && current.address.equals(address) && current.city.equals(city)) {

                        current.name = ans;
                    }

                    break;

                case "p":

                    System.out.println("What would you like to change it to");
                    input.nextLine();
                    ans = input.nextLine();
                    current.phone = ans;

                    break;

                case "a":

                    System.out.println("What would you like to change it to");
                    input.nextLine();
                    ans = input.nextLine();
                    current.address = ans;

                    break;

                case "c":

                    input.nextLine();
                    System.out.println("What would you like to change it to");
                    ans = input.nextLine();
                    current.city = ans;

                    break;
            }

            showContact(current);
        }

        catch(NullPointerException nullPoint){

            System.out.println();
            System.out.println("Contact you wish to change does not exist");
            System.out.println();
        }
    }

    // Displays contacts in phone book.
    public void printBook() {

        System.out.println();
        System.out.println("Phone Book:");
        System.out.println();

        LinkNode current = front;

        if(current == null){

            System.out.println("No contacts in Phone Book");
            System.out.println();
        }

        // Loops through every contact.
        while(current != null){

            System.out.println("Name: " + current.name);
            System.out.println("Phone: " + current.phone);
            System.out.println("Address: " + current.address);
            System.out.println("City: " + current.city);
            System.out.println();

            current = current.next;
        }
    }
}
