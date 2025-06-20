import java.util.Scanner;

/**
 * CET - CS Academic Level 3
 * Declaration: I declare that this is my own original work and is free from Plagiarism
 * This class contains the methods relevant to ReferenceBook
 * Student Name: Dennis Nsi 
 * Student Number: 041149827 
 * Course: CST8130 - Data Structures
 * CET-CS-Level 3
 * Task: Assignment 1
 * @author/Professor James Mwangi PhD. 
 * 
  */


public class ReferenceBook extends Book{
	/**
	 * the edition of a book
	 */
	private String edition;
	/**
	 * Default constructor
	 * */	
	public ReferenceBook() {
		super();
		genre = "Reference";
	}

	/**
	* Custom Constructor
	* @param bookCode - the unique code identifying the book
	* @param title - the title of the book 
	* @param author - the author of the book
	* @param quantityInStock - the number of copies currently in stock
	* @param genre - the genre/category of the book
	*/
	public ReferenceBook(int bookCode, String title, String author, int quantityInStock, String genre) { 
		 super(bookCode, title, author, quantityInStock, genre);
		  genre = "Reference";
	}

	/**
	 * Populates book data by reading from user input via Scanner.
	 * @param scanner The Scanner object used to read user input
	 * @return true if all fields were successfully read, false otherwise
	 */
	public boolean addBook(Scanner scanner) {
		genre = "Reference";
		
		super.addBook(scanner);
		System.out.print("Enter the edition of the book: ");
		edition = scanner.nextLine();
		return true;
	}

	/**
	 * Generates a string representation of the fiction book's details.
	 * @return A formatted string containing all fiction book information
	 */
	@Override
	public String toString() {
		return super.toString() + " Edition: " + edition;
	}

}
