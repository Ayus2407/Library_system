package Library_Management;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;



public class Library {
	 List<Book> books;

	    public Library() {
	        this.books = new ArrayList<>();
	    }

	    public void addBook(String title, String author, int quantity) {
	        Book book = new Book(title, author, quantity);
	        books.add(book);
	        System.out.println("Book added to the library.");
	    }

	    public void displayBooks() {
	        if (books.isEmpty()) {
	            System.out.println("The library is empty.");
	        } else {
	            System.out.println("Library Catalog:");
	            for (Book book : books) {
	                System.out.printf("Title: %s, Author: %s, Available: %d\n", book.title, book.author, book.quantity - book.borrowers.size());
	            }
	        }
	    }

	    public void borrowBook(String title, String username) {
	        for (Book book : books) {
	            if (book.title.equalsIgnoreCase(title)) {
	                if (book.quantity - book.borrowers.size() > 0) {
	                    book.borrowers.put(username, book.borrowers.getOrDefault(username, 0) + 1);
	                    System.out.println("Book borrowed successfully.");
	                } else {
	                    System.out.println("Sorry, this book is currently unavailable.");
	                }
	                return;
	            }
	        }
	        System.out.println("Book not found in the library.");
	    }

	    public void returnBook(String title, String username) {
	        for (Book book : books) {
	            if (book.title.equalsIgnoreCase(title)) {
	                Integer copiesBorrowed = book.borrowers.getOrDefault(username, 0);
	                if (copiesBorrowed > 0) {
	                    book.borrowers.put(username, copiesBorrowed - 1);
	                    book.quantity++;
	                    System.out.println("Book returned successfully.");
	                } else {
	                    System.out.println("You haven't borrowed this book.");
	                }
	                return;
	            }
	        }
	        System.out.println("Book not found in your borrowed list.");
	    }

	    public void searchBook(String query) {
	        boolean found = false;
	        for (Book book : books) {
	            if (book.title.toLowerCase().contains(query.toLowerCase()) || book.author.toLowerCase().contains(query.toLowerCase())) {
	                System.out.printf("Title: %s, Author: %s, Available: %d\n", book.title, book.author, book.quantity - book.borrowers.size());
	                found = true;
	            }
	        }
	        if (!found) {
	            System.out.println("Book not found in the library.");
	        }
	    }

	    public void displayBorrowedBooks() {
	        boolean borrowed = false;
	        System.out.println("Borrowed Books:");
	        for (Book book : books) {
	            for (Map.Entry<String, Integer> entry : book.borrowers.entrySet()) {
	                if (entry.getValue() > 0) {
	                    borrowed = true;
	                    System.out.printf("Title: %s, Author: %s, Borrower: %s, Copies Borrowed: %d\n",
	                            book.title, book.author, entry.getKey(), entry.getValue());
	                }
	            }
	        }
	        if (!borrowed) {
	            System.out.println("No books are currently borrowed.");
	        }
	    }
}