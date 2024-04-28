package Library_Management;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// Class representing a library
public class Library {
    List<Book> books; // List to store books in the library

    // Constructor to initialize the library
    public Library() {
        this.books = new ArrayList<>(); // Initialize the list of books
    }

    // Method to add a new book to the library
    public void addBook(String title, String author, int quantity) {
        Book book = new Book(title, author, quantity); // Create a new Book object
        books.add(book); // Add the book to the list of books
        System.out.println("Book added to the library.");
    }

    // Method to display available books in the library
    public List<String> displayBooks() {
        List<String> bookInfoList = new ArrayList<>();
        if (books.isEmpty()) {
            bookInfoList.add("The library is empty.");
        } else {
        	 System.out.println("Library Catalog:");
            for (Book book : books) {
                String bookInfo = String.format("Title: %s, Author: %s, Available: %d",
                                                book.title, book.author, book.quantity - book.borrowers.size());
                bookInfoList.add(bookInfo);
            }
        }
        return bookInfoList;
    }

    // Method to borrow a book from the library
    public void borrowBook(String title, String username) {
        // Iterate through the list of books to find the specified book
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title)) {
                // Check if the book is available
                if (book.quantity - book.borrowers.size() > 0) {
                    // Update the borrowers map to reflect the borrowing
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

    // Method to return a borrowed book to the library
    public void returnBook(String title, String username) {
        // Iterate through the list of books to find the specified book
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title)) {
                Integer copiesBorrowed = book.borrowers.getOrDefault(username, 0);
                if (copiesBorrowed > 0) {
                    // Update the borrowers map and quantity to reflect the book return
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

    // Method to search for a book by title or author
    public List<String> searchBooks(String query) {
        List<String> matchingBooksInfoList = new ArrayList<>();
        boolean found = false;
        // Iterate through the list of books to find matching books
        for (Book book : books) {
            if (book.title.toLowerCase().contains(query.toLowerCase()) || book.author.toLowerCase().contains(query.toLowerCase())) {
                String bookInfo = String.format("Title: %s, Author: %s, Available: %d",
                                                book.title, book.author, book.quantity - book.borrowers.size());
                matchingBooksInfoList.add(bookInfo);
                found = true;
            }
        }
        if (!found) {
            matchingBooksInfoList.add("Book not found in the library.");
        }
        return matchingBooksInfoList;
    }


    // Method to display borrowed books and their borrowers
    public List<String> displayBorrowedBooksInfo() {
        List<String> borrowedBooksInfoList = new ArrayList<>();
        boolean borrowed = false;
        System.out.println("Borrowed Books:");
        // Iterate through the list of books to find borrowed books
        for (Book book : books) {
            for (Map.Entry<String, Integer> entry : book.borrowers.entrySet()) {
                if (entry.getValue() > 0) {
                    borrowed = true;
                    String bookInfo = String.format("Title: %s, Author: %s, Borrower: %s, Copies Borrowed: %d",
                                                    book.title, book.author, entry.getKey(), entry.getValue());
                    borrowedBooksInfoList.add(bookInfo);
                }
            }
        }
        if (!borrowed) {
            borrowedBooksInfoList.add("No books are currently borrowed.");
        }
        return borrowedBooksInfoList;
    }
}
