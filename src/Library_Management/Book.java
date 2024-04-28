package Library_Management;

import java.util.Map;
import java.util.HashMap;

// Class representing a book in the library
public class Book {
    String title; // Title of the book
    String author; // Author of the book
    int quantity; // Quantity of copies available
    Map<String, Integer> borrowers; // Map to store borrowers and the number of copies borrowed

    // Constructor to initialize the book
    public Book(String title, String author, int quantity) {
        this.title = title; // Initialize the title
        this.author = author; // Initialize the author
        this.quantity = quantity; // Initialize the quantity
        this.borrowers = new HashMap<>(); // Initialize the borrowers map
    }
}
