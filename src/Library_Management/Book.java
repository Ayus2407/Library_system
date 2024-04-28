package Library_Management;
import java.util.Map;
import java.util.HashMap;

public class Book {
	   String title;
	    String author;
	    int quantity;
	    Map<String, Integer> borrowers; // Map to store borrowers and the number of copies borrowed

	    public Book(String title, String author, int quantity) {
	        this.title = title;
	        this.author = author;
	        this.quantity = quantity;
	        this.borrowers = new HashMap<>();
    }
}