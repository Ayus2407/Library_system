package Library_Management;
//
import static org.junit.Assert.*;
import org.junit.Test;
import java.util.List;

public class Library_ManagementTest {

    private Library library;

    public Library_ManagementTest() {
        library = new Library();
    }
    
    @Test
    public void testDisplayBooksEmpty() {
    	List<String> booksInfo = library.displayBooks();
        for (String bookInfo : booksInfo) {
        	assertEquals("The library is empty.",bookInfo);
        }
    }

    @Test
    public void testAddBook() {
        library.addBook("Test Book", "Test Author", 5);
        assertEquals(1, library.books.size());
    }
    
    @Test
    public void testDisplayBooksNonEmpty() {
    	library.addBook("Test Book", "Test Author", 5);
    	List<String> booksInfo = library.displayBooks();
        for (String bookInfo : booksInfo) {
        	assertEquals("Title: Test Book, Author: Test Author, Available: 5", bookInfo);
        }
    }

  @Test
  public void testBorrowBooksDisplay() {
  	library.addBook("Test Book", "Test Author", 5);
  	library.borrowBook("Test Book", "Test User");
  	List<String> booksInfo = library.displayBorrowedBooksInfo();
      for (String bookInfo : booksInfo) {
      	assertEquals("Title: Test Book, Author: Test Author, Borrower: Test User, Copies Borrowed: 1",bookInfo);
      }
  
  }
  
  @Test
  public void testReturnBooksDisplay() {
  	library.addBook("Test Book", "Test Author", 5);
  	library.borrowBook("Test Book", "Test User");
  	List<String> booksInfo = library.displayBorrowedBooksInfo();
      for (String bookInfo : booksInfo) {
      	assertEquals("Title: Test Book, Author: Test Author, Borrower: Test User, Copies Borrowed: 1",bookInfo);
      }
      library.returnBook("Test Book","Test User");
      
      List<String> returnBooksInfo = library.displayBorrowedBooksInfo();
      for (String bookInfo : returnBooksInfo) {
        	assertEquals("No books are currently borrowed.",bookInfo);
        }
  }
  
  @Test
  public void testSearchBooksSuccess() {
  	library.addBook("Test Book", "Test Author", 5);
  	List<String> booksInfo = library.searchBooks("Test Book");
      for (String bookInfo : booksInfo) {
      	assertEquals("Title: Test Book, Author: Test Author, Available: 5",bookInfo);
      }
  
  }
  
  @Test
  public void testSearchBooksFailure() {
  	library.addBook("Test Book", "Test Author", 5);
  	List<String> booksInfo = library.searchBooks("Dummy Book");
      for (String bookInfo : booksInfo) {
      	assertEquals("Book not found in the library.",bookInfo);
      }
  
  }
  
}

