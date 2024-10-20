public class Transaction {
    private int transactionId;
    private int userId;
    private int bookId;
    private String transactionType; // "BORROW" or "RETURN"

    public Transaction(int transactionId, int userId, int bookId, String transactionType) {
        this.transactionId = transactionId;
        this.userId = userId;
        this.bookId = bookId;
        this.transactionType = transactionType;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public int getUserId() {
        return userId;
    }

    public int getBookId() {
        return bookId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    @Override
    public String toString() {
        return "Transaction [Transaction ID=" + transactionId + ", User ID=" + userId + ", Book ID=" + bookId + ", Type=" + transactionType + "]";
    }
}
