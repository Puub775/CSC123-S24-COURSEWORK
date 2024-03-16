import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Library {
    private String name;
    private String address;
    private List<Book> books;
//constructor
    public Library(String name, String address) {
        this.name = name;
        this.address = address;
        this.books = new ArrayList<>();
    }
//getters and setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }
//methods
    @Override
    public String toString() {
        return "Library{" +
                "name='" + name + '\'' +
                ", address=" + address +
                ", books=" + books +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Library library = (Library) o;
        return Objects.equals(name, library.name) &&
                Objects.equals(address, library.address) &&
                Objects.equals(books, library.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address, books);
    }
}
