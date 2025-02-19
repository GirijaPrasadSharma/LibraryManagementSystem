public class Book {
    private int id;
    private String title;
    private String author;
    private boolean isAvailable;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isAvailable = true;
        // By default, the book is available
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {  // Setter method for title
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {  // Setter method for author
        this.author = author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "Book [ID=" + id + ", Title=" + title + ", Author=" + author + ", Available=" + isAvailable + "]";
    }
}
