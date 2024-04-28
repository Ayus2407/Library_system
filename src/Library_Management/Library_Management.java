package Library_Management;
import java.util.Scanner;
import java.util.List;

public class Library_Management {
    public static void main(String[] args) {
        // Create a Library object
        Library library = new Library();
        // Create a Scanner object to take user input
        Scanner scanner = new Scanner(System.in);

        // Display menu options in a loop until the user chooses to quit
        while (true) {
            try {
                System.out.println("\nLibrary Management System");
                System.out.println("1. Add Book");
                System.out.println("2. Display Available Books");
                System.out.println("3. Borrow Book");
                System.out.println("4. Return Book");
                System.out.println("5. Search for a Book");
                System.out.println("6. Display Borrowed Books");
                System.out.println("7. Quit");

                // Prompt user for input
                System.out.print("Enter your choice: ");
                String choice = scanner.nextLine();

                // Perform actions based on user choice
                switch (choice) {
                    case "1":
                        // Add a new book to the library
                        System.out.print("Enter book title: ");
                        String title = scanner.nextLine();
                        System.out.print("Enter author name: ");
                        String author = scanner.nextLine();
                        System.out.print("Enter quantity available: ");
                        int quantity = scanner.nextInt();
                        scanner.nextLine(); // Consume newline character
                        library.addBook(title, author, quantity);
                        break;

                    case "2":
                        // Display available books in the library
                        List<String> booksInfo = library.displayBooks();
                        for (String bookInfo : booksInfo) {
                            System.out.println(bookInfo);
                                }
                                break;


                    case "3":
                        // Borrow a book from the library
                        System.out.print("Enter the title of the book you want to borrow: ");
                        String borrowTitle = scanner.nextLine();
                        System.out.print("Enter your username: ");
                        String borrowUsername = scanner.nextLine();
                        library.borrowBook(borrowTitle, borrowUsername);
                        break;

                    case "4":
                        // Return a borrowed book to the library
                        System.out.print("Enter the title of the book you want to return: ");
                        String returnTitle = scanner.nextLine();
                        System.out.print("Enter your username: ");
                        String returnUsername = scanner.nextLine();
                        library.returnBook(returnTitle, returnUsername);
                        break;

                    case "5":
                        // Search for a book by title or author
                        System.out.print("Enter book title or author name to search: ");
                        String searchQuery = scanner.nextLine();               
                        List<String> matchingBooksInfo = library.searchBooks(searchQuery);
                        for (String bookInfo : matchingBooksInfo) {
                            System.out.println(bookInfo);
                        }
                        break;

                    case "6":
                        // Display borrowed books
                    	List<String> borrowedBooksInfo = library.displayBorrowedBooksInfo();
                    	for (String bookInfo : borrowedBooksInfo) {
                    	    System.out.println(bookInfo);
                    	}

                        break;

                    case "7":
                        // Exit the library system
                        System.out.println("Exiting the library system.");
                        scanner.close();
                        return;

                    default:
                        // Handle invalid input
                        System.out.println("Invalid choice. Please enter a valid option.");
                }
            } catch (Exception e) {
                // Catch any exception that occurs during user input or method calls
            	  System.out.println("Please re enter the correct Values: " + e);
            }
        }
    }
}
