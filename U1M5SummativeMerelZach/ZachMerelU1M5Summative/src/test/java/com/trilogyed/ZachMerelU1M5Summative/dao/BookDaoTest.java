package com.trilogyed.ZachMerelU1M5Summative.dao;

import com.trilogyed.ZachMerelU1M5Summative.model.Book;
import com.trilogyed.ZachMerelU1M5Summative.model.Author;
import com.trilogyed.ZachMerelU1M5Summative.model.Publisher;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BookDaoTest {

    @Autowired
    private BookDao bookDao;

    @Autowired
    private AuthorDao authorDao;

    @Autowired
    private PublisherDao publisherDao;
    private int author_id;
    private int publisher_id;
    private int book_id;

    @Before
    public void setUp() throws Exception {
        bookDao.getAllBooks()
                .stream()
                .forEach(book -> bookDao.deleteBook(book.getBook_id()));

        authorDao.getAllAuthors()
                .stream()
                .forEach(author -> authorDao.deleteAuthor(author.getAuthor_id()));

        publisherDao.getAllPublishers()
                .stream()
                .forEach(publisher -> publisherDao.deletePublisher(publisher.getPublisher_id()));

        Author author = new Author();
        author.setFirst_name("Stephen");
        author.setLast_name("King");
        author.setStreet("Main");
        author.setCity("Derry");
        author.setState("MN");
        author.setPostal_code("03038");
        author.setPhone("1800-HORROR");
        author.setEmail("stehphenking@gmail.com");

        author = authorDao.addAuthor(author);
        this.author_id = author.getAuthor_id();

        Publisher publisher = new Publisher();
        publisher.setName("Scribner ");
        publisher.setStreet("Fifth Ave");
        publisher.setCity("New York");
        publisher.setState("NY");
        publisher.setPostal_code("10029");
        publisher.setPhone("1800-SCRIBNER");
        publisher.setEmail("scribnerpublishing@scribner.com");
        publisher = publisherDao.addPublisher(publisher);
        this.publisher_id = publisher.getPublisher_id();
    }

    @Test
    public void createUpdateDeleteBook() {
        //arrange
        Book bookToInsert = new Book();
        bookToInsert.setIsbn("12345678910");
        bookToInsert.setPublish_date( LocalDate.of(1980,9,9));
        bookToInsert.setAuthor_id(author_id);
        bookToInsert.setTitle("It");
        bookToInsert.setPublisher_id(publisher_id);
        bookToInsert.setPrice(BigDecimal.valueOf(8.99));

        //act
        Book bookAfterInsert = bookDao.addBook(bookToInsert);

        Book bookIExpect = new Book();
        bookIExpect.setBook_id(bookAfterInsert.getBook_id());
        bookIExpect.setIsbn("12345678910");
        bookIExpect.setPublish_date(LocalDate.of(1980,9,9));
        bookIExpect.setAuthor_id(author_id);
        bookIExpect.setTitle("It");
        bookIExpect.setPublisher_id(publisher_id);
        bookIExpect.setPrice(BigDecimal.valueOf(8.99));

        Book bookIGot = bookDao.getBook(bookAfterInsert.getBook_id());
        //assert
        assertEquals(bookIExpect, bookIGot);
    }

    @Test
    public void updateBook() {
        //arrange
        Book bookToInsert = new Book();
        bookToInsert.setIsbn("12345678910");
        bookToInsert.setPublish_date(LocalDate.of(1980,9,9));
        bookToInsert.setAuthor_id(author_id);
        bookToInsert.setTitle("It");
        bookToInsert.setPublisher_id(publisher_id);
        bookToInsert.setPrice(BigDecimal.valueOf(8.99));

        Book bookAfterInsert = bookDao.addBook(bookToInsert);

        Book bookUpdate = new Book();
        bookUpdate.setBook_id(bookAfterInsert.getBook_id());
        bookUpdate.setIsbn("10987654321");
        bookUpdate.setPublish_date(LocalDate.of(1999,1,7));
        bookUpdate.setAuthor_id(author_id);
        bookUpdate.setTitle("Harry Potter");
        bookUpdate.setPublisher_id(publisher_id);
        bookUpdate.setPrice(BigDecimal.valueOf(5.99));

        Book bookIExpect = new Book();
        bookIExpect.setBook_id(bookAfterInsert.getBook_id());
        bookIExpect.setIsbn("10987654321");
        bookIExpect.setPublish_date(LocalDate.of(1999,1,7));
        bookIExpect.setAuthor_id(author_id);
        bookIExpect.setTitle("Harry Potter");
        bookIExpect.setPublisher_id(publisher_id);
        bookIExpect.setPrice(BigDecimal.valueOf(5.99));

        //act
        bookDao.updateBook(bookUpdate);
        Book bookIGot = bookDao.getBook(bookIExpect.getBook_id());

        //assert

        assertEquals(bookIExpect, bookIGot);
    }

    // covered by createGetDelete
//    @Test
//    public void deleteBook() {
//    }

    // covered by createGetDelete
//    @Test
//    public void addBook() {
//    }

    // covered by createGetDelete
//    @Test
//    public void getBook() {
//    }
    @Test
    public void getAllBooks() {
        //arrange
        Book book1 = new Book();
        book1.setIsbn("10987654321");
        book1.setPublish_date(LocalDate.of(1999,1,7));
        book1.setAuthor_id(author_id);
        book1.setTitle("Harry Potter");
        book1.setPublisher_id(publisher_id);
        book1.setPrice(BigDecimal.valueOf(5.99));

        Book book2 = new Book();
        book2.setIsbn("12345678910");
        book2.setPublish_date(LocalDate.of(1980,9,9));
        book2.setAuthor_id(author_id);
        book2.setTitle("It");
        book2.setPublisher_id(publisher_id);
        book2.setPrice(BigDecimal.valueOf(8.99));

        bookDao.addBook(book1);
        bookDao.addBook(book2);

        //act
        List<Book> books = bookDao.getAllBooks();
        //assert

        assertEquals(2, books.size());


    }

    @Test
    public void getBookByAuthor() {
        //arrange
        Author author2 = new Author();
        author2.setFirst_name("Brandon");
        author2.setLast_name("Sanderson");
        author2.setStreet("Park");
        author2.setCity("Lincoln");
        author2.setState("NE");
        author2.setPostal_code("68501");
        author2.setPhone("1800-FANTASY");
        author2.setEmail("brandonsanderson@gmail.com");

        author2 = authorDao.addAuthor(author2);

        Book book1 = new Book();
        book1.setIsbn("12345678910");
        book1.setPublish_date(LocalDate.of(1980,9,9));
        book1.setAuthor_id(author_id);
        book1.setTitle("It");
        book1.setPublisher_id(publisher_id);
        book1.setPrice(BigDecimal.valueOf(8.99));

        Book book2 = new Book();
        book2.setIsbn("10987654321");
        book2.setPublish_date(LocalDate.of(1999,1,7));
        book2.setAuthor_id(author2.getAuthor_id());
        book2.setTitle("Harry Potter");
        book2.setPublisher_id(publisher_id);
        book2.setPrice(BigDecimal.valueOf(8.99));

        book1 = bookDao.addBook(book1);
        book2 = bookDao.addBook(book2);

        //act
        List<Book> theActualResult = bookDao.getBookByAuthor(author_id);
        List<Book> theThingWeExpect = new ArrayList<>();
        theThingWeExpect.add(book1);
        assertEquals(theThingWeExpect, theActualResult);

        assertEquals(author_id, theActualResult.get(0).getAuthor_id());
    }

}