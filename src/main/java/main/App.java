package main;

import java.util.Scanner;

public class App {
    public static void main( String[] args ) {
        Library library = new Library();
        Scanner sc = new Scanner(System.in);
        
        // Selection menu loop
        while (true) {
            System.out.println("1) Lisää kirja\n2) Listaa kirjat\n3) Lainaa fiktiokirja\n4) Palauta fiktiokirja\n0) Lopeta ohjelma");
            int choice = sc.nextInt();
            sc.nextLine();
            
            // Choices
            switch (choice) {
                case 1:
                    System.out.println("Minkä kirjan haluat lisätä kirjastoon? 1) Fiktiokirja, 2) Tietokirja");
                    int type = sc.nextInt();
                    sc.nextLine();
                    
                    System.out.println("Anna kirjan nimi:");
                    String title = sc.nextLine();
                    System.out.println("Anna kirjailijan nimi:");
                    String author = sc.nextLine();
                    System.out.println("Anna sivumäärä:");
                    int pages = sc.nextInt();
                    System.out.println("Anna kirjojen määrä:");
                    int copies = sc.nextInt();
                    sc.nextLine();
                    
                    if (type == 1) {
                        library.addBook(new FictionBook(title, author, pages, copies));
                    } else if (type == 2) {
                        library.addBook(new NonFictionBook(title, author, pages, copies));
                    } else {
                        System.out.println("Virheellinen kirjatyyppi.");
                        break;
                    }
                    break;
                case 2:
                    library.listBooks();
                    break;
                case 3:
                    System.out.println("Anna lainattavan kirjan nimi:");
                    String borrowTitle = sc.nextLine();
                    Book borrowBook = library.findBook(borrowTitle);
                    if (borrowBook instanceof FictionBook) {
                        ((FictionBook) borrowBook).borrow();
                    } else {
                        System.out.println("Kirjaa ei löytynyt tai sitä ei voi lainata.");
                    }
                    break;
                case 4:
                    System.out.println("Anna palautettavan kirjan nimi:");
                    String returnTitle = sc.nextLine();
                    Book returnBook = library.findBook(returnTitle);
                    if (returnBook instanceof FictionBook) {
                        ((FictionBook) returnBook).returnBook();
                    } else {
                        System.out.println("Kirjaa ei löytynyt tai sitä ei voi palauttaa.");
                    }
                    break;
                case 0:
                    System.out.println("Kiitos ohjelman käytöstä.");
                    sc.close();
                    return;
                default:
                    System.out.println("Virheellinen valinta!");
            }
        }
    }
}