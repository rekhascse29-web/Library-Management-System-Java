import java.util.ArrayList;
import java.util.Scanner;

// ---------------- BOOK CLASS ----------------
class Book {
    private int id;
    private String title;
    private String author;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
}

// ---------------- LIBRARY CLASS ----------------
class Library {
    private ArrayList<Book> bookList;

    public Library() {
        bookList = new ArrayList<>();
    }

    public void addBook(Book book) {
        bookList.add(book);
        System.out.println("Book added successfully!");
    }

    public void removeBook(int id) {
        for (Book b : bookList) {
            if (b.getId() == id) {
                bookList.remove(b);
                System.out.println("Book removed successfully!");
                return;
            }
        }
        System.out.println("Book not found!");
    }

    public void searchBook(String title) {
        for (Book b : bookList) {
            if (b.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Book Found:");
                System.out.println(b.getId() + " - " + b.getTitle() + " - " + b.getAuthor());
                return;
            }
        }
        System.out.println("Book not found!");
    }

    public void displayBooks() {
        if (bookList.isEmpty()) {
            System.out.println("No books available.");
            return;
        }

        System.out.println("\nBook List:");
        for (Book b : bookList) {
            System.out.println(b.getId() + " - " + b.getTitle() + " - " + b.getAuthor());
        }
    }
}

// ---------------- MAIN CLASS ----------------
public class Main {
    public static void main(String[] args) {

        Library lib = new Library();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== LIBRARY MENU =====");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Search Book");
            System.out.println("4. Display Books");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {

                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();

                    lib.addBook(new Book(id, title, author));
                    break;

                case 2:
                    System.out.print("Enter Book ID to remove: ");
                    int removeId = sc.nextInt();
                    lib.removeBook(removeId);
                    break;

                case 3:
                    System.out.print("Enter Book Title to search: ");
                    String searchTitle = sc.nextLine();
                    lib.searchBook(searchTitle);
                    break;

                case 4:
                    lib.displayBooks();
                    break;

                case 5:
                    System.out.println("Exiting program...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}