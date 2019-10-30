package com.trilogyed.ZachMerelU1Capstone.dao;

import com.trilogyed.ZachMerelU1Capstone.model.TShirt;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TShirtDaoTest {

    @Autowired
    private GameDao gameDao;
    @Autowired
    private ConsoleDao consoleDao;
    @Autowired
    private TShirtDao tShirtDao;
    @Autowired
    private TaxesDao taxesDao;
    @Autowired
    private ProcessingFeeDao processingFeeDao;

    @Before
    public void setUp() throws Exception {
        tShirtDao.getAllTShirts()
                .stream()
                .forEach(tShirt -> tShirtDao.deleteTShirt(tShirt.getT_shirt_id()));
    }


    @Test
    public void shouldAddGetDeleteTShirt() {
        //arrange
        TShirt tShirtToInsert = new TShirt();
        tShirtToInsert.setSize("Large");
        tShirtToInsert.setColor("Black");
        tShirtToInsert.setDescription("mens black tshirt");
        tShirtToInsert.setPrice(BigDecimal.valueOf(8.99));
        tShirtToInsert.setQuantity(1);

        //act
        TShirt tShirtAfterInsert = tShirtDao.addTShirt(tShirtToInsert);

        TShirt tShirtIExpect = new TShirt();
        tShirtIExpect.setT_shirt_id(tShirtAfterInsert.getT_shirt_id());
        tShirtIExpect.setSize("Large");
        tShirtIExpect.setColor("Black");
        tShirtIExpect.setDescription("mens black tshirt");
        tShirtIExpect.setPrice(BigDecimal.valueOf(8.99));
        tShirtIExpect.setQuantity(1);

        TShirt tShirtIGot = tShirtDao.getTShirt(tShirtAfterInsert.getT_shirt_id());

        //assert
        assertEquals(tShirtIExpect, tShirtIGot);

        tShirtDao.deleteTShirt(tShirtIExpect.getT_shirt_id());

        tShirtIExpect = tShirtDao.getTShirt(tShirtIExpect.getT_shirt_id());

        assertNull(tShirtIExpect);


    }
    //Test should be fulfilled by the shouldAddGetDeleteTShirt Test
//    @Test
//    public void addTShirt() {
//    }
//
//    @Test
//    public void getTShirt() {
//    }
//    @Test
//    public void deleteTShirt() {
//    }

    @Test
    public void getAllTShirts() {
        //arrange
        TShirt tShirt1 = new TShirt();
        tShirt1.setSize("Large");
        tShirt1.setColor("Black");
        tShirt1.setDescription("mens black tshirt");
        tShirt1.setPrice(BigDecimal.valueOf(8.99));
        tShirt1.setQuantity(1);

        TShirt tShirt2 = new TShirt();
        tShirt2.setSize("Medium");
        tShirt2.setColor("Blue");
        tShirt2.setDescription("womens blue tshirt");
        tShirt2.setPrice(BigDecimal.valueOf(8.99));
        tShirt2.setQuantity(1);

        tShirtDao.addTShirt(tShirt1);
        tShirtDao.addTShirt(tShirt2);

        //act
        List<TShirt> tShirts = tShirtDao.getAllTShirts();

        //assert
        assertEquals(2, tShirts.size());
    }

    @Test
    public void getAllTShirtsByColor() {
        //arrange
        TShirt tShirt1 = new TShirt();
        tShirt1.setSize("Large");
        tShirt1.setColor("Black");
        tShirt1.setDescription("mens black tshirt");
        tShirt1.setPrice(BigDecimal.valueOf(8.99));
        tShirt1.setQuantity(1);

        TShirt tShirt2 = new TShirt();
        tShirt2.setSize("Large");
        tShirt2.setColor("Black");
        tShirt2.setDescription("mens black tshirt");
        tShirt2.setPrice(BigDecimal.valueOf(8.99));
        tShirt2.setQuantity(1);

        tShirtDao.addTShirt(tShirt1);
        tShirtDao.addTShirt(tShirt2);

        //act
        List<TShirt> tShirts = tShirtDao.getAllTShirtsByColor("Black");

        //assert
        assertEquals(2, tShirts.size());
    }

    @Test
    public void getAllTShirtsBySize() {
        //arrange
        TShirt tShirt1 = new TShirt();
        tShirt1.setSize("Large");
        tShirt1.setColor("Black");
        tShirt1.setDescription("mens black tshirt");
        tShirt1.setPrice(BigDecimal.valueOf(8.99));
        tShirt1.setQuantity(1);

        TShirt tShirt2 = new TShirt();
        tShirt2.setSize("Large");
        tShirt2.setColor("Black");
        tShirt2.setDescription("mens black tshirt");
        tShirt2.setPrice(BigDecimal.valueOf(8.99));
        tShirt2.setQuantity(1);

        tShirtDao.addTShirt(tShirt1);
        tShirtDao.addTShirt(tShirt2);

        //act
        List<TShirt> tShirts = tShirtDao.getAllTShirtsBySize("Large");

        //assert
        assertEquals(2, tShirts.size());
    }

    @Test
    public void updateTShirt() {
        //arrange
        TShirt tShirtToInsert = new TShirt();
        tShirtToInsert.setSize("Large");
        tShirtToInsert.setColor("Black");
        tShirtToInsert.setDescription("mens black tshirt");
        tShirtToInsert.setPrice(BigDecimal.valueOf(8.99));
        tShirtToInsert.setQuantity(1);

        TShirt tShirtAfterInsert = tShirtDao.addTShirt(tShirtToInsert);

        TShirt tShirtUpdate = new TShirt();
        tShirtUpdate.setT_shirt_id(tShirtAfterInsert.getT_shirt_id());
        tShirtUpdate.setSize("Small");
        tShirtUpdate.setColor("Red");
        tShirtUpdate.setDescription("mens red tshirt");
        tShirtUpdate.setPrice(BigDecimal.valueOf(7.99));
        tShirtUpdate.setQuantity(1);

        TShirt tShirtIExpect= new TShirt();
        tShirtIExpect.setT_shirt_id(tShirtAfterInsert.getT_shirt_id());
        tShirtIExpect.setSize("Small");
        tShirtIExpect.setColor("Red");
        tShirtIExpect.setDescription("mens red tshirt");
        tShirtIExpect.setPrice(BigDecimal.valueOf(7.99));
        tShirtIExpect.setQuantity(1);

        //act
        tShirtDao.updateTShirt(tShirtUpdate);
        TShirt tShirtIGot = tShirtDao.getTShirt(tShirtIExpect.getT_shirt_id());

        //assert
        assertEquals(tShirtIExpect, tShirtIGot);


    }


}