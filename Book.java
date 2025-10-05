public class Book {
    public static Book[] books = new Book[5];
    public String title;
    public String author;
    public int yearPublished;
    public int currentPage;

    
    public Book(String title, String author, int yearPublished, int currentPage) {
       
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.currentPage = currentPage;

    }
}
