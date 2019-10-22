package com.trilogyed.ZachMerelU1M5Summative.dao;

import com.trilogyed.ZachMerelU1M5Summative.model.Publisher;
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
public class PublisherDaoTest {

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
    public void createGetDeletePublisher() {
        //arrange
        Publisher publisherToAdd = new Publisher();
        publisherToAdd.setName("Scribner ");
        publisherToAdd.setStreet("Fifth Ave");
        publisherToAdd.setCity("New York");
        publisherToAdd.setState("NY");
        publisherToAdd.setPostal_code("10029");
        publisherToAdd.setPhone("1800-SCRIBNER");
        publisherToAdd.setEmail("scribnerpublishing@scribner.com");

        //act - create
        Publisher publisherAfterAdding = publisherDao.addPublisher(publisherToAdd);
        publisherToAdd.setPublisher_id(publisherAfterAdding.getPublisher_id());

        //assert - create
        assertEquals(publisherToAdd, publisherAfterAdding);

        //act - get
        Publisher thePublisherWeGotFromTheDatabase = publisherDao.getPublisher(publisherToAdd.getPublisher_id());

        //assert -get
        assertEquals(publisherToAdd, thePublisherWeGotFromTheDatabase);

        //act -delete
        publisherDao.deletePublisher(publisherToAdd.getPublisher_id());
        Publisher thePublisherAfterDeleteIt = publisherDao.getPublisher(publisherToAdd.getPublisher_id());

        //assert - delete
        assertEquals(thePublisherAfterDeleteIt, null);


    }

    // covered in create-get-delete
//    @Test
//    public void getPublisher() {
//    }

    // covered in create-get-delete
//    @Test
//    public void addPublisher() {
//    }

    // covered in create-get-delete
//    @Test
//    public void deletePublisher() {
//    }

    @Test
    public void updatePublisher(){
        //arrange
        Publisher publisherToInsert = new Publisher();
        publisherToInsert.setName("Scribner ");
        publisherToInsert.setStreet("Fifth Ave");
        publisherToInsert.setCity("New York");
        publisherToInsert.setState("NY");
        publisherToInsert.setPostal_code("10029");
        publisherToInsert.setPhone("1800-SCRIBNER");
        publisherToInsert.setEmail("scribnerpublishing@scribner.com");

        Publisher publisherAfterInsert = publisherDao.addPublisher(publisherToInsert);

        Publisher publisherUpdated = new Publisher();
        publisherUpdated.setPublisher_id(publisherAfterInsert.getPublisher_id());
        publisherUpdated.setName("Penguin Random House");
        publisherUpdated.setStreet("Sixth");
        publisherUpdated.setCity("New York");
        publisherUpdated.setState("NY");
        publisherUpdated.setPostal_code("10030");
        publisherUpdated.setPhone("1800-PENGUIN");
        publisherUpdated.setEmail("randompenguin@house.com");

        Publisher whatIExpect = new Publisher();
        whatIExpect.setPublisher_id(publisherAfterInsert.getPublisher_id());
        whatIExpect.setName("Penguin Random House");
        whatIExpect.setStreet("Sixth");
        whatIExpect.setCity("New York");
        whatIExpect.setState("NY");
        whatIExpect.setPostal_code("10030");
        whatIExpect.setPhone("1800-PENGUIN");
        whatIExpect.setEmail("randompenguin@house.com");

        //act
        publisherDao.updatePublisher(publisherUpdated);

        Publisher whatIGot = publisherDao.getPublisher(whatIExpect.getPublisher_id());

        //assert
        assertEquals(whatIExpect, whatIGot);

    }

    @Test
    public void getAllPublishers(){
        //arrange
        Publisher publisher1 = new Publisher();
        publisher1.setName("Scribner ");
        publisher1.setStreet("Fifth Ave");
        publisher1.setCity("New York");
        publisher1.setState("NY");
        publisher1.setPostal_code("10029");
        publisher1.setPhone("1800-SCRIBNER");
        publisher1.setEmail("scribnerpublishing@scribner.com");

        Publisher publisher2 = new Publisher();
        publisher2.setName("Penguin Random House ");
        publisher2.setStreet("Sixth");
        publisher2.setCity("New York");
        publisher2.setState("NY");
        publisher2.setPostal_code("10030");
        publisher2.setPhone("1800-PENGUIN");
        publisher2.setEmail("randompenguin@house.com");

        publisher1 = publisherDao.addPublisher(publisher1);
        publisher2 = publisherDao.addPublisher(publisher2);

        //act
        List<Publisher> whatIGot = publisherDao.getAllPublishers();

        //assert
        assertEquals(2, whatIGot.size());

    }
}