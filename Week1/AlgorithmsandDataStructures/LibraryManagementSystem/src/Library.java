import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Library {
    private List<Book> books;

    // Constructor
    public Library() {
        books = new ArrayList<>();
    }

    // Method to add a book to the library
    public void addBook(Book book) {
        books.add(book);
        // Sort the books by title for binary search
        Collections.sort(books, Comparator.comparing(Book::getTitle));
    }

    // Method to search for a book by title using binary search
    public Book binarySearchByTitle(String title) {
        int left = 0;
        int right = books.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            Book midBook = books.get(mid);
            int comparison = midBook.getTitle().compareToIgnoreCase(title);

            if (comparison == 0) {
                return midBook;
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return null; // Book not found
    }

    public static void main(String[] args) {
        // Initialize the library and add books
        Library library = new Library();
        library.addBook(new Book(1, "The Great Gatsby", "F. Scott Fitzgerald"));
        library.addBook(new Book(2, "To Kill a Mockingbird", "Harper Lee"));
        library.addBook(new Book(3, "1984", "George Orwell"));

        // Search for a book by title using binary search
        System.out.println("Book found by title '1984':");
        Book bookFound = library.binarySearchByTitle("1984");
        if (bookFound != null) {
            System.out.println(bookFound);
        } else {
            System.out.println("Book not found.");
        }
    }
}
