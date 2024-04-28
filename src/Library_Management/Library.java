package Library_Management;

import java.util.ArrayList;
import java.util.List;



public class Library {
    List<Book> books;
    List<Book> borrowedBooks;

    public Library() {
        this.books = new ArrayList<>();
        this.borrowedBooks = new ArrayList<>();
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
                System.out.printf("Title: %s, Author: %s, Available: %d\n", book.title, book.author, book.quantity - book.borrowed);
            }
        }
    }

    public void borrowBook(String title) {
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title)) {
                if (book.quantity - book.borrowed > 0) {
                    book.borrowed++;
                    borrowedBooks.add(book);
                    System.out.println("Book borrowed successfully.");
                } else {
                    System.out.println("Sorry, this book is currently unavailable.");
                }
                return;
            }
        }
        System.out.println("Book not found in the library.");
    }

    public void returnBook(String title) {
        for (Book book : borrowedBooks) {
            if (book.title.equalsIgnoreCase(title)) {
                if (book.borrowed > 0) {
                    book.borrowed--;
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
                System.out.printf("Title: %s, Author: %s, Available: %d\n", book.title, book.author, book.quantity - book.borrowed);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Book not found in the library.");
        }
    }

    public void displayBorrowedBooks() {
        if (borrowedBooks.isEmpty()) {
            System.out.println("You haven't borrowed any books.");
        } else {
            System.out.println("Borrowed Books:");
            for (Book book : borrowedBooks) {
                System.out.printf("Title: %s, Author: %s\n", book.title, book.author);
            }
        }
    }
}