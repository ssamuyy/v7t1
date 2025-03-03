package main;

import java.util.ArrayList;

// Library class controls the happenings of the library
public class Library {
    private ArrayList<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Kirja lisätty kirjastoon!");
    }
    
    public void listBooks() {
        if (books.isEmpty()) {
            System.out.println("Kirjasto on tyhjä.");
        }
        int totalCopies = 0;
        for (Book book : books) {
            book.displayInfo();
            System.out.println("Kirjan kategoria: " + book.categorize());
            totalCopies += book.getCopies();
        }
        System.out.println("Kirjojen määrä kirjastossa on: " + totalCopies);
    }
    
    public Book findBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }
}
