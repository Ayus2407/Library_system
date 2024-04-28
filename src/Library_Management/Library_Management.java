package Library_Management;
import java.util.Scanner;

public class Library_Management {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Display Available Books");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. Search for a Book");
            System.out.println("6. Display Borrowed Books");
            System.out.println("7. Quit");

            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
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
                    library.displayBooks();
                    break;

                case "3":
                    System.out.print("Enter the title of the book you want to borrow: ");
                    String borrowTitle = scanner.nextLine();
                    library.borrowBook(borrowTitle);
                    break;

                case "4":
                    System.out.print("Enter the title of the book you want to return: ");
                    String returnTitle = scanner.nextLine();
                    library.returnBook(returnTitle);
                    break;

                case "5":
                    System.out.print("Enter book title or author name to search: ");
                    String searchQuery = scanner.nextLine();
                    library.searchBook(searchQuery);
                    break;

                case "6":
                    library.displayBorrowedBooks();
                    break;

                case "7":
                    System.out.println("Exiting the library system.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
