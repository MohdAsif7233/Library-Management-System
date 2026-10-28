import java.util.Scanner;

// Book Class: Encapsulates individual book details
class Book {
    private int id;
    private String title;
    private String author;
    private boolean isAvailable;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isAvailable = true; // Default state is available
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

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }

    public void displayBookDetails() {
        String status = isAvailable ? "Available" : "Borrowed";
        System.out.printf("ID: %-4d | Title: %-30s | Author: %-20s | Status: %s\n", id, title, author, status);
    }
}

// Library Class: Manages the collection of books using an array
class Library {
    private Book[] books;

    public Library() {
        // Initializing with at least 5 sample books
        books = new Book[] {
            new Book(101, "Java Basics", "Herbert Schildt"),
            new Book(102, "Object-Oriented Programming", "E. Balagurusamy"),
            new Book(103, "Data Structures", "Seymour Lipschutz"),
            new Book(104, "Computer Networks", "Andrew S. Tanenbaum"),
            new Book(105, "Database Fundamentals", "Raghu Ramakrishnan")
        };
    }

    // 1. Display all books
    public void displayBooks() {
        System.out.println("\n--- Library Books ---");
        for (Book b : books) {
            b.displayBookDetails();
        }
    }

    // 2. Search book by title (case-insensitive substring match)
    public void searchBook(String query) {
        System.out.println("\n--- Search Results ---");
        boolean found = false;
        for (Book b : books) {
            if (b.getTitle().toLowerCase().contains(query.toLowerCase())) {
                b.displayBookDetails();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No book found matching: \"" + query + "\"");
        }
    }

    // 3. Borrow a book by ID
    public void borrowBookById(int id) {
        Book book = findBookById(id);
        if (book == null) {
            System.out.println("Error: Book with ID " + id + " does not exist.");
        } else if (!book.isAvailable()) {
            System.out.println("Sorry, \"" + book.getTitle() + "\" is already borrowed.");
        } else {
            book.setAvailable(false);
            System.out.println("Success: You have borrowed \"" + book.getTitle() + "\".");
        }
    }

    // 4. Return a book by ID
    public void returnBookById(int id) {
        Book book = findBookById(id);
        if (book == null) {
            System.out.println("Error: Book with ID " + id + " does not exist.");
        } else if (book.isAvailable()) {
            System.out.println("Notice: \"" + book.getTitle() + "\" was not borrowed.");
        } else {
            book.setAvailable(true);
            System.out.println("Success: You have returned \"" + book.getTitle() + "\".");
        }
    }

    // 5. Show library summary
    public void showSummary() {
        int total = books.length;
        int availableCount = 0;
        int borrowedCount = 0;

        for (Book b : books) {
            if (b.isAvailable()) {
                availableCount++;
            } else {
                borrowedCount++;
            }
        }

        System.out.println("\n--- Library Summary ---");
        System.out.println("Total Books     : " + total);
        System.out.println("Available Books : " + availableCount);
        System.out.println("Borrowed Books  : " + borrowedCount);
    }

    // Helper method to locate a book by ID
    private Book findBookById(int id) {
        for (Book b : books) {
            if (b.getId() == id) {
                return b;
            }
        }
        return null;
    }
}

// Main Class: Handles user interaction and menu flow
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();
        int choice = -1;

        System.out.println("==================================================");
        System.out.println("  Welcome to AIMT Library Management System");
        System.out.println("==================================================");

        while (choice != 0) {
            System.out.println("\n------------- MENU -------------");
            System.out.println("1. Display all books");
            System.out.println("2. Search book by title");
            System.out.println("3. Borrow a book");
            System.out.println("4. Return a book");
            System.out.println("5. Show library summary");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            // Input validation for integer choices
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // clear invalid input
                continue;
            }

            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline left-over

            switch (choice) {
                case 1:
                    library.displayBooks();
                    break;

                case 2:
                    System.out.print("Enter book title to search: ");
                    String titleQuery = scanner.nextLine().trim();
                    library.searchBook(titleQuery);
                    break;

                case 3:
                    System.out.print("Enter Book ID to borrow: ");
                    if (scanner.hasNextInt()) {
                        int borrowId = scanner.nextInt();
                        scanner.nextLine();
                        library.borrowBookById(borrowId);
                    } else {
                        System.out.println("Invalid ID format.");
                        scanner.nextLine();
                    }
                    break;

                case 4:
                    System.out.print("Enter Book ID to return: ");
                    if (scanner.hasNextInt()) {
                        int returnId = scanner.nextInt();
                        scanner.nextLine();
                        library.returnBookById(returnId);
                    } else {
                        System.out.println("Invalid ID format.");
                        scanner.nextLine();
                    }
                    break;

                case 5:
                    library.showSummary();
                    break;

                case 0:
                    System.out.println("\nThank you for using the Library Management System. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option! Please choose between 0 and 5.");
            }
        }

        scanner.close();
    }
}