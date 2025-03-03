package main;

// Non fiction books inherit from book but are not borrowable
public class NonFictionBook extends Book {
    public NonFictionBook(String title, String author, int pages, int copies) {
        super(title, author, pages, copies);
    }
    
    @Override
    public String categorize() {
        return "Tietokirja";
    }
}