import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LibraryManager libraryManager = new LibraryManager();
        boolean running = true;

        while (running) {
            System.out.println("\nLibrary Management System:");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Update Book");
            System.out.println("4. Delete Book");
            System.out.println("5. Add User");
            System.out.println("6. View Users");
            System.out.println("7. Borrow Book");
            System.out.println("8. Return Book");
            System.out.println("9. View Transactions");
            System.out.println("10. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    int bookId = scanner.nextInt();
                    scanner.nextLine();  // consume newline
                    System.out.print("Enter Book Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Book Author: ");
                    String author = scanner.nextLine();
                    libraryManager.addBook(new Book(bookId, title, author));
                    break;
                case 2:
                    libraryManager.displayBooks();
                    break;
                case 3:
                    System.out.print("Enter Book ID to update: ");
                    int updateBookId = scanner.nextInt();
                    scanner.nextLine();  // consume newline
                    System.out.print("Enter new Book Title: ");
                    String newTitle = scanner.nextLine();
                    System.out.print("Enter new Book Author: ");
                    String newAuthor = scanner.nextLine();
                    libraryManager.updateBook(updateBookId, newTitle, newAuthor);
                    break;
                case 4:
                    System.out.print("Enter Book ID to delete: ");
                    int deleteBookId = scanner.nextInt();
                    libraryManager.deleteBook(deleteBookId);
                    break;
                case 5:
                    System.out.print("Enter User ID: ");
                    int userId = scanner.nextInt();
                    scanner.nextLine();  // consume newline
                    System.out.print("Enter User Name: ");
                    String userName = scanner.nextLine();
                    libraryManager.addUser(new User(userId, userName));
                    break;
                case 6:
                    libraryManager.displayUsers();
                    break;
                case 7:
                    System.out.print("Enter User ID: ");
                    int borrowUserId = scanner.nextInt();
                    System.out.print("Enter Book ID: ");
                    int borrowBookId = scanner.nextInt();
                    libraryManager.borrowBook(borrowUserId, borrowBookId);
                    break;
                case 8:
                    System.out.print("Enter User ID: ");
                    int returnUserId = scanner.nextInt();
                    System.out.print("Enter Book ID: ");
                    int returnBookId = scanner.nextInt();
                    libraryManager.returnBook(returnUserId, returnBookId);
                    break;
                case 9:
                    libraryManager.displayTransactions();
                    break;
                case 10:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
        System.out.println("Thank you for using the Library Management System!");
    }
}
