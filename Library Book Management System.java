import java.util.Random;
import java.util.Scanner;

public class Library_Book_Management_System {

    static Book[] books = new Book[5];
    static int count = 0;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {

            System.out.println("**********************************");
            System.out.println("*      WELCOME TO THE LIBRARY    *");
            System.out.println("**********************************");
            System.out.println("1. Add Book");
            System.out.println("2. Update Book Status");
            System.out.println("3. Show All Books");
            System.out.println("4. Generate Report");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    updateBookStatus();
                    break;
                case 3:
                    showBooks();
                    break;
                case 4:
                    generateReport();
                    break;
                case 5:
                    System.out.println("Exiting program... Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 5);
    }

    public static void addBook() {
        if (count < books.length) {
            System.out.print("Enter book title: ");
            String title = sc.nextLine();
            books[count] = new Book(title);
            count++;
            System.out.println("Book added successfully!");
        } else {
            System.out.println("Book limit reached. Cannot add more.");
        }
    }

    public static void updateBookStatus() {
        if (count == 0) {
            System.out.println("No books to update.");
            return;
        }

        showBooks();
        System.out.print("Enter book number to update: ");
        int num = sc.nextInt();
        sc.nextLine();

        if (num >= 1 && num <= count) {
            Book b = books[num - 1];
            if (b.status.equals("Available")) {
                b.status = "Borrowed";
            } else {
                b.status = "Available";
            }
            System.out.println("Book status updated.");
        } else {
            System.out.println("Invalid book number.");
        }
    }

    public static void showBooks() {
        if (count == 0) {
            System.out.println("No books available.");
            return;
        }
        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ". " + books[i].title + " - " + books[i].status);
        }
    }

    public static void generateReport() {
        int available = 0, borrowed = 0;

        for (int i = 0; i < count; i++) {
            if (books[i].status.equals("Available")) {
                available++;
            } else {
                borrowed++;
            }
        }

        System.out.println("----- REPORT -----");
        System.out.println("Total books: " + count);
        System.out.println("Available: " + available);
        System.out.println("Borrowed: " + borrowed);
    }
}

class Book {
    String title;
    String status;

    Book(String title) {
        this.title = title;
        this.status = "Available";
    }
}