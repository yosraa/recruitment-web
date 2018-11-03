package fr.d2factory.libraryapp.library;

import fr.d2factory.libraryapp.book.Book;
import fr.d2factory.libraryapp.book.BookRepository;
import fr.d2factory.libraryapp.member.Member;

import java.time.LocalDate;

public class LibraryImpl implements Library {

   BookRepository bookRepository;

    @Override
    public Book borrowBook(long isbnCode, Member member, LocalDate borrowedAt) throws HasLateBooksException {
       Book book= bookRepository.findBook(isbnCode);
       member.setWallet(isbnCode);
       bookRepository.saveBookBorrow(book,borrowedAt);
        return book;
    }

    @Override
    public void returnBook(Book book, Member member) {
        LocalDate d =bookRepository.findBorrowedBookDate(book);
       int day = LocalDate.now().getDayOfMonth()-d.getDayOfMonth();
       member.payBook(day);



    }
}
