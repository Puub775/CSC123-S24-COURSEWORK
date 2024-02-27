public class LibraryTest {
    public static void main(String[] args) {
        // Create a Library
        Library library = new Library("Huntington Park Community Library", "123");

        // Create some books
        Book book1 = new Book("Brave", "Michael J.", 396, "1234567890");
        Book book2 = new Book("Narnia", "Peter B.", 693, "0987654321");

        // Add books to the library
        library.addBook(book1);
        library.addBook(book2);

        // Display library 
        System.out.println("Library Information:");
        System.out.println(library);

        // Display all books 
        System.out.println("\nBooks in the Library:");
        for (Book book : library.getBooks()) {
            System.out.println(book);
        }

        // Remove a book 
        library.removeBook(book1);

        // Display new Library info
        System.out.println("Updated Library Information:");
        System.out.println(library);
        }
}

        // Check equality of two libraries
        