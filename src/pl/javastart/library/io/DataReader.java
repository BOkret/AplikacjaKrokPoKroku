package pl.javastart.library.io;
import pl.javastart.library.model.Book;
import pl.javastart.library.model.Magazine;

import java.util.Scanner;

public class DataReader {
    private Scanner sc = new Scanner(System.in);
    private ConsolePrinter printer;

    public DataReader(ConsolePrinter printer) {
        this.printer = printer;
    }

    public Book readAndCreateBook(){
        printer.printLine("Tytuł:");
        String title = sc.nextLine();
        printer.printLine("Autor:");
        String author = sc.nextLine();
        printer.printLine("Wydawnictwo:");
        String publisher = sc.nextLine();
        printer.printLine("ISBN:");
        String isbn = sc.nextLine();
        printer.printLine("Rok wydania:");
        int releaseDate = getInt();
        printer.printLine("Liczba stron:");
        int pages = getInt();


        return new Book(title, author, releaseDate, pages, publisher, isbn);
    }

    public Magazine readAndCreateMagazine(){
        printer.printLine("Tytuł:");
        String title = sc.nextLine();
        printer.printLine("Wydawnictwo:");
        String publisher = sc.nextLine();
        printer.printLine("Język:");
        String language = sc.nextLine();
        printer.printLine("Rok wydania:");
        int releaseDate = getInt();
        printer.printLine("Miesiąc:");
        int month = getInt();
        printer.printLine("Dzień:");
        int day = getInt();

        return new Magazine(title, publisher, language, releaseDate, month, day);
    }

    public int getInt(){
        try {
            return sc.nextInt();
        } finally {
            sc.nextLine();
        }
    }

    public void close(){
        sc.close();
    }

    public void testMessage(){
        printer.printLine("test nr 2");
    }

    public void printNoMeaningInfo(){
        printer.printLine("tekst testowy");
    }

    public String getString(){
        return sc.nextLine();
    }
}
