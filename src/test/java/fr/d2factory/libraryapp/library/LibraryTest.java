package fr.d2factory.libraryapp.library;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.google.gson.Gson;
import fr.d2factory.libraryapp.book.Book;
import fr.d2factory.libraryapp.book.BookRepository;
import fr.d2factory.libraryapp.book.ISBN;
import fr.d2factory.libraryapp.member.Member;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import static sun.security.krb5.Confounder.longValue;

public class LibraryTest {
    private Library library;
    private BookRepository bookRepository;
    private List<Book> books;

    @Before
    public void setup() {
        //TODO instantiate the library and the repository
        bookRepository = new BookRepository();
        //TODO add some test books (use BookRepository#addBooks)
        //TODO to help you a file called books.json is available in src/test/resources
        books = new ArrayList<>();
         books=get_data_from_json();

         bookRepository.addBooks(books);



    }

    @Test
    public void member_can_borrow_a_book_if_book_is_available() {

        Long iscode = 46578964513L;
        Book book   = bookRepository.findBook(iscode);
        assertNotNull("il peut emprunter le livre car il existe",book);


    }

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

    public    List<Book>   get_data_from_json() {
        //read json file data to Object
        ObjectMapper objectMapper = new ObjectMapper();

      File file = new File("C:\\Users\\yosraaddali\\IdeaProjects\\recruitment-web\\src\\test\\resources\\books.json");

        TypeReference<List<Book>> mapType = new TypeReference<List<Book>>() {};
       try {




           List<Book> jsonTopersonList= objectMapper.readValue( file, mapType);

    return  jsonTopersonList;
      } catch (IOException e) {
           e.printStackTrace();
        }
return null;

    }
}
