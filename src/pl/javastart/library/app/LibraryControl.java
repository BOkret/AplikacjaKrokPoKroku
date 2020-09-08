package pl.javastart.library.app;

import pl.javastart.library.io.DataReader;
import pl.javastart.library.model.Book;
import pl.javastart.library.model.Library;

public class LibraryControl {

    //zmienne do kontrolowania programu
    private final int exit = 0;
    private final int addBooks = 1;
    private final int printBooks = 2;

    //zmienna do komunikacji z użytkownikiem
    private DataReader dataReader = new DataReader();

    //"biblioteka" przechowująca dane
    private Library library = new Library();

    void controlLoop(){
        int option;

        do{
            printOptions();
            option = dataReader.getInt();
            switch (option){
                case addBooks:
                    addBook();
                    break;
                case printBooks:
                    printBooks();
                    break;
                case exit:
                    exit();
                    break;
                default:
                    System.out.println("Nie ma takiej opcji, wprowadź ponownie");
            }
        } while (option != exit);
    }

    private void exit() {
        System.out.println("Koniec programu, cześć");
        //zamykamy strumień wejścia
        dataReader.close();
    }

    private void printBooks() {
        library.printBooks();
    }

    private void addBook(){
        Book book = dataReader.readAndCreateBook();
        library.addBook(book);
    }

    private void printOptions() {
        System.out.println("Wybierz opcję:");
        System.out.println(exit + " - wyjście z programu");
        System.out.println(addBooks + " - dodanie nowej książki");
        System.out.println(printBooks + " - wyświetl dostępne książki");
    }
}
