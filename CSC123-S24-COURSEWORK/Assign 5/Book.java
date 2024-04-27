//Name: Pablo Conde 
//Email: pconde1@csudh.edu
public class Book extends Material {
    private String author;
    private String isbn;
    private int numberOfPages;

    public Book(int itemReference, String title, double replacementValue, String location, boolean isSuitableForChildren, String author, String isbn, int numberOfPages) {
        super(itemReference, title, replacementValue, location, isSuitableForChildren);
        this.author = author;
        this.isbn = isbn;
        this.numberOfPages = numberOfPages;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }
}