package fr.d2factory.libraryapp.library;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationConfig;
import fr.d2factory.libraryapp.book.Book;
import fr.d2factory.libraryapp.book.BookRepository;
import fr.d2factory.libraryapp.member.Member;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.fail;

public class LibraryTest {
    private Library library;
    private BookRepository bookRepository;
    private List<Book> books;

    @Before
    public void setup() {
        //TODO instantiate the library and the repository

        //TODO add some test books (use BookRepository#addBooks)
        //TODO to help you a file called books.json is available in src/test/resources
        books = new ArrayList<>();
        books.add(get_data_from_json());
        bookRepository = new BookRepository();
        bookRepository.addBooks(books);


    }

    @Test
    public void member_can_borrow_a_book_if_book_is_available() { fail("Implement me"); }

    @Test
    public void borrowed_book_is_no_longer_available() {
        fail("Implement me");
    }

    @Test
    public void residents_are_taxed_10cents_for_each_day_they_keep_a_book() {
        fail("Implement me");
    }

    @Test
    public void students_pay_10_cents_the_first_30days() {
        fail("Implement me");
    }

    @Test
    public void students_in_1st_year_are_not_taxed_for_the_first_15days() {
        fail("Implement me");
    }

    @Test
    public void students_pay_15cents_for_each_day_they_keep_a_book_after_the_initial_30days() {
        fail("Implement me");
    }

    @Test
    public void residents_pay_20cents_for_each_day_they_keep_a_book_after_the_initial_60days() {
        fail("Implement me");
    }

    @Test
    public void members_cannot_borrow_book_if_they_have_late_books() {


        get_data_from_json();


    }

    public Book get_data_from_json() {
        //read json file data to Object
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(DeserializationFeature.UNWRAP_ROOT_VALUE);
        try {
            return objectMapper.readValue(new File("C:\\Users\\yosraaddali\\IdeaProjects\\recruitment-web\\src\\test\\resources\\books.json"), Book.class);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
