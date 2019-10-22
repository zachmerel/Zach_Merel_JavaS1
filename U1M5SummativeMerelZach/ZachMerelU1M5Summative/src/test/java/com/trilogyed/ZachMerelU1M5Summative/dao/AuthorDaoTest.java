package com.trilogyed.ZachMerelU1M5Summative.dao;

import com.trilogyed.ZachMerelU1M5Summative.model.Author;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AuthorDaoTest {

    @Autowired
    private BookDao bookDao;

    @Autowired
    private AuthorDao authorDao;

    @Autowired
    private PublisherDao publisherDao;


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
    }


    @Test
    public void createGetDeleteAuthor(){
        //arrange
        Author authorToAdd = new Author();
        authorToAdd.setFirst_name("Stephen");
        authorToAdd.setLast_name("King");
        authorToAdd.setStreet("Main");
        authorToAdd.setCity("Derry");
        authorToAdd.setState("MN");
        authorToAdd.setPostal_code("03038");
        authorToAdd.setPhone("1800-HORROR");
        authorToAdd.setEmail("stehphenking@gmail.com");

        //act -create
        Author authorAfterAdding = authorDao.addAuthor(authorToAdd);
        authorToAdd.setAuthor_id(
                authorAfterAdding.getAuthor_id());

        //assert - create
        assertEquals(authorToAdd, authorAfterAdding);

        //act - get
        Author theAuthorWeGotFromTheDatabase = authorDao.getAuthor(authorToAdd.getAuthor_id());

        //assert - get
        assertEquals(authorToAdd, theAuthorWeGotFromTheDatabase);

        //act - delete
        authorDao.deleteAuthor(authorToAdd.getAuthor_id());
        Author theAuthorAfterDeletedIt = authorDao.getAuthor(authorToAdd.getAuthor_id());

        //assert - delete
        assertEquals(theAuthorAfterDeletedIt, null);

    }

    // covered in create-get-delete
//    @Test
//    public void getAuthor() {
//    }

    // covered in create-get-delete
//    @Test
//    public void addAuthor() {
//    }

    // covered in create-get-delete
//    @Test
//    public void deleteAuthor() {
//    }

    @Test
    public void updateAuthor(){
        //arrange
        Author authorToInsert = new Author();
        authorToInsert.setFirst_name("Stephen");
        authorToInsert.setLast_name("King");
        authorToInsert.setStreet("Main");
        authorToInsert.setCity("Derry");
        authorToInsert.setState("MN");
        authorToInsert.setPostal_code("03038");
        authorToInsert.setPhone("1800-HORROR");
        authorToInsert.setEmail("stehphenking@gmail.com");

        Author authorAfterInsert = authorDao.addAuthor(authorToInsert);

        Author authorUpdated = new Author();
        authorUpdated.setAuthor_id(authorAfterInsert.getAuthor_id());
        authorUpdated.setFirst_name("Brnadon");
        authorUpdated.setLast_name("Sanderson");
        authorUpdated.setStreet("Park");
        authorUpdated.setCity("Lincoln");
        authorUpdated.setState("NE");
        authorUpdated.setPostal_code("68501");
        authorUpdated.setPhone("1800-FANTASY");
        authorUpdated.setEmail("brandonsanderson@gmail.com");

        Author whatIExpect = new Author ();
        whatIExpect.setAuthor_id(authorAfterInsert.getAuthor_id());
        whatIExpect.setFirst_name("Brnadon");
        whatIExpect.setLast_name("Sanderson");
        whatIExpect.setStreet("Park");
        whatIExpect.setCity("Lincoln");
        whatIExpect.setState("NE");
        whatIExpect.setPostal_code("68501");
        whatIExpect.setPhone("1800-FANTASY");
        whatIExpect.setEmail("brandonsanderson@gmail.com");

        //act
        authorDao.updateAuthor(authorUpdated);

        Author whatIGot = authorDao.getAuthor(whatIExpect.getAuthor_id());

        //assert
        assertEquals(whatIExpect, whatIGot);
    }

    @Test
    public void getAllAuthors(){
        //arrange
        Author author1 = new Author();
        author1.setFirst_name("Stephen");
        author1.setLast_name("King");
        author1.setStreet("Main");
        author1.setCity("Derry");
        author1.setState("MN");
        author1.setPostal_code("03038");
        author1.setPhone("1800-HORROR");
        author1.setEmail("stehphenking@gmail.com");

        Author author2 = new Author();
        author2.setFirst_name("Brnadon");
        author2.setLast_name("Sanderson");
        author2.setStreet("Park");
        author2.setCity("Lincoln");
        author2.setState("NE");
        author2.setPostal_code("68501");
        author2.setPhone("1800-FANTASY");
        author2.setEmail("brandonsanderson@gmail.com");

        author1 = authorDao.addAuthor(author1);
        author2 = authorDao.addAuthor(author2);

        //act
        List<Author> whatIGot = authorDao.getAllAuthors();

        //assert
        assertEquals(2, whatIGot.size());

    }
}