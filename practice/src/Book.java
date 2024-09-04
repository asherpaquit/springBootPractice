import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Book {
    private String title;
    private String author;

    // Constructor
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    // Overriding hashCode()
    @Override
    public int hashCode() {
        return Objects.hash(title, author); // Generates a hash code based on title and author
    }

    // Overriding equals()
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Book book = (Book) obj;
        return title.equals(book.title) && author.equals(book.author);
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    public static void main(String[] args) {
        // Create a HashMap to store books and their prices
        Map<Book, Double> bookPrices = new HashMap<>();

        // Create some Book objects
        Book book1 = new Book("Effective Java", "Joshua Bloch");
        Book book2 = new Book("Clean Code", "Robert C. Martin");
        Book book3 = new Book("Effective Java", "Joshua Bloch");

        // Add books to the map with their prices
        bookPrices.put(book1, 45.00);
        bookPrices.put(book2, 40.00);
        bookPrices.put(book3, 50.00); // This will replace book1's entry because book1.equals(book3)

        // Retrieve and print the prices of the books
        System.out.println("Price of Effective Java: " + bookPrices.get(book1));
        System.out.println("Price of Clean Code: " + bookPrices.get(book2));

        // Print the size of the map (should be 2 because book1 and book3 are considered equal)
        System.out.println("Total books in the map: " + bookPrices.size());
    }
}

