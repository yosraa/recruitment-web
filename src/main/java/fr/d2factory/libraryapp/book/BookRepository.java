package fr.d2factory.libraryapp.book;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toMap;

/**
 * The book repository emulates a database via 2 HashMaps
 */
public class BookRepository {
    private Map<ISBN, Book> availableBooks = new HashMap<>();
    private Map<Book, LocalDate> borrowedBooks = new HashMap<>();

    public void addBooks(List<Book> books){
        //TODO implement the missing feature
           books.stream()
                //.filter(book -> availableBooks.containsValue(book))
                .forEach(book -> {
                availableBooks.put(book.isbn,book);
        });

    }

    public Book findBook(long isbnCode) {
        //TODO implement the missing feature

        for (Map.Entry<ISBN, Book> entry : availableBooks.entrySet()) {
            if (entry.getKey().isbnCode==isbnCode) {
               return entry.getValue();
            }
        }

        return null;
    }

    public void saveBookBorrow(Book book, LocalDate borrowedAt){
        //TODO implement the missing feature
        borrowedBooks.put(book,borrowedAt);
    }

    public LocalDate findBorrowedBookDate(Book book) {
        //TODO implement the missing feature
        Map<Book, LocalDate> sortedByValue = borrowedBooks.entrySet()
                     .stream()
                     .filter( b -> b.getValue().equals( book))
                     .collect(toMap(Map.Entry::getKey,
                             Map.Entry::getValue));
         return sortedByValue.get(book);

    }
}
