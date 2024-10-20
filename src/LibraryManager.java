import java.util.ArrayList;
import java.util.List;

public class LibraryManager {
    private List<Book> books;
    private List<User> users;
    private List<Transaction> transactions;
    private int transactionIdCounter = 1;  // Auto-incrementing ID for transactions

    public LibraryManager() {
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
        this.transactions = new ArrayList<>();
    }

    // CRUD for Books
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully!");
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
        } else {
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    public void updateBook(int id, String newTitle, String newAuthor) {
        for (Book book : books) {
            if (book.getId() == id) {
                book.setTitle(newTitle);
                book.setAuthor(newAuthor);
                System.out.println("Book updated successfully!");
                return;
            }
        }
        System.out.println("Book with ID " + id + " not found.");
    }

    public void deleteBook(int id) {
        books.removeIf(book -> book.getId() == id);
        System.out.println("Book deleted successfully!");
    }

    // CRUD for Users
    public void addUser(User user) {
        users.add(user);
        System.out.println("User added successfully!");
    }

    public void displayUsers() {
        if (users.isEmpty()) {
            System.out.println("No users available.");
        } else {
            for (User user : users) {
                System.out.println(user);
            }
        }
    }

    public void updateUser(int id, String newName) {
        for (User user : users) {
            if (user.getId() == id) {
                user.setName(newName);
                System.out.println("User updated successfully!");
                return;
            }
        }
        System.out.println("User with ID " + id + " not found.");
    }

    public void deleteUser(int id) {
        users.removeIf(user -> user.getId() == id);
        System.out.println("User deleted successfully!");
    }

    // Transaction operations (borrow and return books)
    public void borrowBook(int userId, int bookId) {
        Book bookToBorrow = null;
        for (Book book : books) {
            if (book.getId() == bookId && book.isAvailable()) {
                bookToBorrow = book;
                break;
            }
        }

        if (bookToBorrow == null) {
            System.out.println("Book is either not available or does not exist.");
            return;
        }

        for (User user : users) {
            if (user.getId() == userId) {
                bookToBorrow.setAvailable(false);
                transactions.add(new Transaction(transactionIdCounter++, userId, bookId, "BORROW"));
                System.out.println("Book borrowed successfully!");
                return;
            }
        }
        System.out.println("User with ID " + userId + " not found.");
    }

    public void returnBook(int userId, int bookId) {
        Book bookToReturn = null;
        for (Book book : books) {
            if (book.getId() == bookId && !book.isAvailable()) {
                bookToReturn = book;
                break;
            }
        }

        if (bookToReturn == null) {
            System.out.println("Book is either already returned or does not exist.");
            return;
        }

        for (User user : users) {
            if (user.getId() == userId) {
                bookToReturn.setAvailable(true);
                transactions.add(new Transaction(transactionIdCounter++, userId, bookId, "RETURN"));
                System.out.println("Book returned successfully!");
                return;
            }
        }
        System.out.println("User with ID " + userId + " not found.");
    }

    // Display all transactions
    public void displayTransactions() {
        if (transactions.isEmpty()) {
            System.out.println("No transactions available.");
        } else {
            for (Transaction transaction : transactions) {
                System.out.println(transaction);
            }
        }
    }
}

