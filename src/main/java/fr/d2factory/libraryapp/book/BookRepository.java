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
                .filter(book -> availableBooks.containsValue(book))
                .forEach(book -> {
                availableBooks.put(new ISBN(Long.numberOfTrailingZeros(3)),book);
        });

    }

    public Book findBook(long isbnCode) {
        //TODO implement the missing feature
        if (availableBooks.containsKey(isbnCode))
            return availableBooks.get(isbnCode);
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
