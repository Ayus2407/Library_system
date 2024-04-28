package Library_Management;
//
import static org.junit.Assert.*;
//
//import org.junit.Test;
//
//public class Library_ManagementTest {
//
//	@Test
//	public void test() {
//		fail("Not yet implemented");
//	}
//
//}

import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

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

//    @Test
//    public void testDisplayBooksNonEmpty() {
//        library.addBook("Test Book", "Test Author", 5);
//        assertEquals("Library Catalog:\nTitle: Test Book, Author: Test Author, Available: 5\n", getOutput(() -> library.displayBooks()));
//    }
//
//    @Test
//    public void testBorrowBookSuccess() {
//        library.addBook("Test Book", "Test Author", 1);
//        library.borrowBook("Test Book", "User1");
//        assertEquals("Book borrowed successfully.\n", getOutput(() -> library.borrowBook("Test Book", "User2")));
//    }
//
//    @Test
//    public void testBorrowBookFailure() {
//        library.addBook("Test Book", "Test Author", 0);
//        assertEquals("Sorry, this book is currently unavailable.\n", getOutput(() -> library.borrowBook("Test Book", "User1")));
//    }
//
//    @Test
//    public void testReturnBookSuccess() {
//        library.addBook("Test Book", "Test Author", 1);
//        library.borrowBook("Test Book", "User1");
//        assertEquals("Book returned successfully.\n", getOutput(() -> library.returnBook("Test Book", "User1")));
//    }
//
//    @Test
//    public void testReturnBookFailure() {
//        library.addBook("Test Book", "Test Author", 1);
//        assertEquals("You haven't borrowed this book.\n", getOutput(() -> library.returnBook("Test Book", "User1")));
//    }
//
//    @Test
//    public void testSearchBookFound() {
//        library.addBook("Test Book", "Test Author", 1);
//        assertEquals("Title: Test Book, Author: Test Author, Available: 1\n", getOutput(() -> library.searchBook("Test")));
//    }
//
//    @Test
//    public void testSearchBookNotFound() {
//        assertEquals("Book not found in the library.\n", getOutput(() -> library.searchBook("Test")));
//    }
//
//    @Test
//    public void testDisplayBorrowedBooksEmpty() {
//        assertEquals("No books are currently borrowed.\n", getOutput(() -> library.displayBorrowedBooks()));
//    }
//
//    @Test
//    public void testDisplayBorrowedBooksNonEmpty() {
//        library.addBook("Test Book", "Test Author", 1);
//        library.borrowBook("Test Book", "User1");
//        assertEquals("Borrowed Books:\nTitle: Test Book, Author: Test Author, Borrower: User1, Copies Borrowed: 1\n", getOutput(() -> library.displayBorrowedBooks()));
//    }
//
  
}

