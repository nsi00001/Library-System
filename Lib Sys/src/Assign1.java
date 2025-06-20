import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * CET - CS Academic Level 3
 * Declaration: I declare that this is my own original work and is free from Plagiarism
 * This class contains the main method and its menu method
 * Student Name: Dennis Nsi 
 * Student Number: 041149827 
 * Course: CST8130 - Data Structures
 * CET-CS-Level 3
 * Task: Assignment 1
 * @author/Professor James Mwangi PhD. 
  */

public class Assign1 {
	
	/**
     * Default constructor for Assign1
     */
    public Assign1() {
    }
	
/**
 * Main method in class Assign1
 * @param args is a String array
 */
public static void main(String[] args) {
        
        // Initialize scanner for user input
        Scanner input = new Scanner(System.in);
        int choice = 0;  // Stores user menu choice
        Library l = new Library();
        
        do {
        	Assign1.displayMainMenu();    
            
            try {
                choice = input.nextInt();
                input.nextLine();
            } catch(InputMismatchException e) {
                System.out.println("...Invalid input, please tryp again...");
                input.nextLine();
                continue;  // Skip to next iteration if input is invalid
            }
        
            switch(choice) {
                case 1: 
                    // Initialize default array
                
                	l.addBook(input);               	
                    break;
                case 2:
                	 System.out.println("Library Catalog:");
                	 if(l != null) {
                		 l.toString();
                	 }
                    break;
                case 3:
                	if(l != null) {
                	l.borrowBook(input);
             	}else {
                	System.out.print("Error...could not borrow book");
             	}
                    break;
                case 4:
                	if(l != null) {
                		l.returnBook(input);                        	
             	}else {
                	System.out.print("Error...could not return book");
             	}
                	break;
                case 5:
                     // Exit program
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("...Invalid input, please try again...");
            }

            System.out.println();
        } while(choice != 5);
        
        input.close();  // Close scanner when done
    }

    /**
     * Displays all the menu options for the user to choose from.
     */
    private static void displayMainMenu() {
        System.out.println("Please select one of the following:");
        System.out.println("1. Add Book to Library");
        System.out.println("2. Display Current Library Catalog");
        System.out.println("3. Borrow Book(s)");
        System.out.println("4. Return Book(s)");
        System.out.println("5. To Exit");
        System.out.print("> ");
    }
}
