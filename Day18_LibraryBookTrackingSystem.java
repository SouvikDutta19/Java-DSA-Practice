import java.util.*;

class Book {
    String title;
    boolean isAvailable;

    Book(String title) {
        this.title = title;
        this.isAvailable = true;
    }
}

class Library {
    Map<String, Book> books = new HashMap<>();

    void addBook(String title) {
        books.put(title, new Book(title));
        System.out.println("Added book: " + title);
    }

    void issueBook(String title) {
        Book book = books.get(title);
        if (book == null) {
            System.out.println("Book not found.");
        } else if (!book.isAvailable) {
            System.out.println("Book already issued.");
        } else {
            book.isAvailable = false;
            System.out.println("Book issued: " + title);
        }
    }

    void returnBook(String title) {
        Book book = books.get(title);
        if (book == null || book.isAvailable) {
            System.out.println("Invalid return attempt.");
        } else {
            book.isAvailable = true;
            System.out.println("Book returned: " + title);
        }
    }

    void showStatus() {
        System.out.println("Library Status:");
        for (Book book : books.values()) {
            System.out.println(book.title + " -> " + (book.isAvailable ? "Available" : "Issued"));
        }
    }
}

public class Day18_LibraryBookTrackingSystem {
    public static void main(String[] args) {
        Library lib = new Library();
        lib.addBook("Java Basics");
        lib.addBook("Data Structures");
        lib.issueBook("Java Basics");
        lib.returnBook("Java Basics");
        lib.showStatus();
    }
}
