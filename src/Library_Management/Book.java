package Library_Management;

public class Book {
    String title;
    String author;
    int quantity;
    int borrowed;

    public Book(String title, String author, int quantity) {
        this.title = title;
        this.author = author;
        this.quantity = quantity;
    }
}
