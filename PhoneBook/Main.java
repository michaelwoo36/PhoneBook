// Michael Woo
// CS 145
// Assignment 2: Phone Book
// IntelliJ

package PhoneBook;
import java.util.Scanner;

public class Main {

    public static void main(String [] args){

        Scanner input = new Scanner(System.in);
        PhoneBookManager book = new PhoneBookManager(input);
        boolean ask = true;

        // Loops until the user decides to close the phone book.
        while(ask) {

            // asks user what they want to do with phone book.
            book.ask();

            String ans = input.next();

            switch (ans) {

                case "a":

                    book.add();
                    break;

                case "r":

                    book.remove();
                    break;

                case "c":

                    book.change();
                    break;

                case "d":

                    book.printBook();
                    break;

                case "e":

                    ask = false;
                    break;

                // In case of incorrect input.
                default:

                    System.out.println();
                    System.out.println("Not an option. Please enter one of the operational keys keys");
                    System.out.println();

            }
        }
    }
}
