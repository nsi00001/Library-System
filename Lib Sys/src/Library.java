import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * CET - CS Academic Level 3
 * Declaration: I declare that this is my own original work and is free from Plagiarism
 * This class contains the methods relevant to Library operations
 * Student Name: Dennis Nsi 
 * Student Number: 041149827 
 * Course: CST8130 - Data Structures
 * CET-CS-Level 3
 * Task: Assignment 1
 * @author/Professor James Mwangi PhD. 
 * 
  */


public class Library {
	/**
	 * catalog is an array of type Book
	 */
	private Book[] catalog;
	/**
	 * keeps track of the number of books in the array
	 */
	private int numBooks;
	
	/**
	 * Default constructor for Library class
	 */
	public Library() {
		numBooks=0;
		catalog = new Book[20];
	}

	/**
	 * Returns a string representation of all books in the catalog
	 * @return empty string 
	 */
	@Override
	public String toString() {
		// Iterate through all books in catalog
		for(int i=0; i<catalog.length; i++) {
			if(catalog[i] != null) {
			System.out.println(catalog[i].toString());
			}
		}
		return "";
}
	
	/**
	 * Checks if a book already exists in the catalog
	 * @param book the Book object to check for existence
	 * @return index of the existing book if found, -1 otherwise
	 */
	public int alreadyExists(Book book) {
		 
		for(int i=0; i<catalog.length; i++) {
		if(catalog[i] != null && catalog[i].isEqual(book)) {
			return i;
		 }
		}
		return -1;
	}
	
	/**
	 * Adds a new book to the library catalog
	 * @param scanner takes the user input
	 * @return a boolean based on if the operation was successful or not
	 */
	public boolean addBook(Scanner scanner) {
		boolean result=false;
		 // Check if catalog is full
		if(numBooks >= catalog.length) {
			System.out.println("Catalog is full");
			return false;
		}
		String inpt="";
		Book newBook = null;
		// Get book type from user
		do {
			System.out.print("Do you wish to add a Fiction(f), Non-Fiction(n), or Reference(r) book?");
		   inpt = scanner.nextLine().toLowerCase();
		// Create appropriate book type based on input 
	switch (inpt) {
	case "f":
		newBook = new FictionBook();
		break;
	case "n":
			newBook = new NonFictionBook();
		break;
    case "r":
		newBook = new ReferenceBook();
		break;
	 default: 
		 System.out.println("Invalid entry");
	} 
	}while(newBook == null);
		// Attempt to add book details
	if(!newBook.addBook(scanner)) {
			return result;
		}
	// Check if book already exists
		 if(alreadyExists(newBook) != -1) {
			 System.out.println("Book code already exists.");
			 return result;
		}
		// Add book to catalog
		 catalog[numBooks] = newBook;
		 numBooks++;
		
		 return true;
	}


	/**
	 * Borrows a book from the library catalog
	 * @param scanner Scanner for user input
	 * @return true if borrow was successful, false otherwise
	 */
	public boolean borrowBook(Scanner scanner) {
	   
	    try {
	    	 if(numBooks == 0) {
	    		 System.out.println("Error...could not borrow book");
	    		 return false;
	    	 }
	        System.out.print("Enter the book code to borrow: ");
	        int code = scanner.nextInt();
	        scanner.nextLine();
	        Book b = null;
	     // Search for book in catalog
	        for (int i = 0; i < numBooks; i++) {
		        if (catalog[i].bookCode == code) {      
		            b = catalog[i];
		            break;
		        }
		    }
	        //Book no found case
	        if (b == null) {
	            System.out.println("Error...could not borrow book");
	            return false;
	        }
	    
	             // Check if book is reference (can't be borrowed)
	        if (b.genre.equals("Reference")) {
	            System.out.println("Error: Reference books cannot be borrowed");
	            return false;
	        }
	        System.out.print("Enter quantity to borrow: ");
	        int quantity = scanner.nextInt();
	        scanner.nextLine(); // Consume newline
	        
	     // Validate and process borrowing
	        if(quantity > 0 && quantity <= b.quantityInStock ) {
	        b.updateQuantity(-quantity);
	        return true;
	        }else {
	        	System.out.println("Error...could not borrow book");
	 	       	return false;
	        }
	    } catch (InputMismatchException e) {
	        System.out.println("Error: Invalid input");
	        scanner.nextLine(); // Clear invalid input
	        return false;
	    }
	}

	/**
	 * Returns a book to the library catalog
	 * @param scanner Scanner for user input
	 * @return true if return was successful, false otherwise
	 */
	public boolean returnBook(Scanner scanner) {
	    
	    try {
	    	if(numBooks == 0) {
	    		 System.out.println("Error...could not borrow book");
	    		 return false;
	    	 }
	    	System.out.print("Enter the code for the book: ");
	        int code = scanner.nextInt();
	        scanner.nextLine(); // Consume newline
	     // Search for book in catalog
	        Book b = null;
	        for (int i = 0; i < numBooks; i++) {
		        if (catalog[i].bookCode == code) {
		            b = catalog[i];
		            break;
		        }
		    }
	       //Book not found case
	       if(b == null) {
	    	   System.out.println("Error...could not return book");
	    	   return false;
	       }       
	        System.out.print("Enter valid quantity to return: ");
	        int quantity = scanner.nextInt();
	        scanner.nextLine(); // Consume newline 
	        
	        // Reference books cannot be returned (as they can't be borrowed)
	        if(b.genre.equals("Reference")) {
	        	 System.out.println("Error...could not return book");
	        	 return false;
	       }
      
	     // Validate and process borrowing
	        if(quantity > 0 && quantity <= b.max - b.quantityInStock ) {
	        b.updateQuantity(quantity);
	        System.out.println("Successfully returned " + quantity + " copies");
	        return true;
	        }else {
	        	System.out.println("Error...could not return book");
	 	       	return false;
	        }
	    }catch (InputMismatchException e) {
	        System.out.println("Error: Invalid input");
	        scanner.nextLine(); // Clear invalid input
	        return false;
	    }
	}
}
	


