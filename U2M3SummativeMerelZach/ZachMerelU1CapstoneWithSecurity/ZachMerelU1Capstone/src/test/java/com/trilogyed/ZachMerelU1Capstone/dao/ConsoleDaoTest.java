package com.trilogyed.ZachMerelU1Capstone.dao;

import com.trilogyed.ZachMerelU1Capstone.model.Console;
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
public class ConsoleDaoTest {

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
        consoleDao.getAllConsoles()
                .stream()
                .forEach(console -> consoleDao.deleteConsole(console.getConsole_id()));
    }

    @Test
    public void shouldAddGetDeleteConsole(){
        //arrange
        Console consoleToInsert = new Console();
        consoleToInsert.setModel("Playstation 2");
        consoleToInsert.setManufacturer("Sony");
        consoleToInsert.setMemory_amount("16mb");
        consoleToInsert.setProcessor("sony2001");
        consoleToInsert.setPrice(BigDecimal.valueOf(39.99));
        consoleToInsert.setQuantity(1);

        //act

        Console consoleAfterInsert = consoleDao.addConsole(consoleToInsert);

        Console consoleIExpect = new Console();
        consoleIExpect.setConsole_id(consoleAfterInsert.getConsole_id());
        consoleIExpect.setModel("Playstation 2");
        consoleIExpect.setManufacturer("Sony");
        consoleIExpect.setMemory_amount("16mb");
        consoleIExpect.setProcessor("sony2001");
        consoleIExpect.setPrice(BigDecimal.valueOf(39.99));
        consoleIExpect.setQuantity(1);

        Console consoleIGot = consoleDao.getConsole(consoleAfterInsert.getConsole_id());

        //assert

        assertEquals(consoleIExpect, consoleIGot);

        consoleDao.deleteConsole(consoleIExpect.getConsole_id());

        consoleIExpect = consoleDao.getConsole(consoleIExpect.getConsole_id());

        assertNull(consoleIExpect);
    }

    //Test should be fulfilled by the addGetDeleteConsole Test
//    @Test
//    public void addConsole() {
//    }
//
//    @Test
//    public void getConsole() {
//    }
//
//    @Test
//    public void deleteConsole() {
//    }

    @Test
    public void getAllConsoles() {
        //arrange
        Console console1 = new Console();
        console1.setModel("Playstation 2");
        console1.setManufacturer("Sony");
        console1.setMemory_amount("16mb");
        console1.setProcessor("sony2001");
        console1.setPrice(BigDecimal.valueOf(39.99));
        console1.setQuantity(1);

        Console console2 = new Console();
        console2.setModel("Playstation 4");
        console2.setManufacturer("Sony");
        console2.setMemory_amount("1TB");
        console2.setProcessor("sony2012");
        console2.setPrice(BigDecimal.valueOf(349.99));
        console2.setQuantity(1);

        consoleDao.addConsole(console1);
        consoleDao.addConsole(console2);

        //act
        List<Console> consoles = consoleDao.getAllConsoles();

        //assert
        assertEquals(2, consoles.size());
    }

    @Test
    public void getAllConsolesByManufacturer() {
        //arrange
        Console console1 = new Console();
        console1.setModel("Playstation 2");
        console1.setManufacturer("Sony");
        console1.setMemory_amount("16mb");
        console1.setProcessor("sony2001");
        console1.setPrice(BigDecimal.valueOf(39.99));
        console1.setQuantity(1);

        consoleDao.addConsole(console1);

        //act
        List<Console> consoles = consoleDao.getAllConsolesByManufacturer("Sony");

        //assert
        assertEquals(1, consoles.size());
    }

    @Test
    public void updateConsole() {
        //arrange
        Console consoleToInsert = new Console();
        consoleToInsert.setModel("Playstation 2");
        consoleToInsert.setManufacturer("Sony");
        consoleToInsert.setMemory_amount("16mb");
        consoleToInsert.setProcessor("sony2001");
        consoleToInsert.setPrice(BigDecimal.valueOf(39.99));
        consoleToInsert.setQuantity(1);

        Console consoleAfterInsert = consoleDao.addConsole(consoleToInsert);

        Console consoleUpdate = new Console();
        consoleUpdate.setConsole_id(consoleAfterInsert.getConsole_id());
        consoleUpdate.setModel("Playstation 4");
        consoleUpdate.setManufacturer("Sony");
        consoleUpdate.setMemory_amount("1TB");
        consoleUpdate.setProcessor("sony2012");
        consoleUpdate.setPrice(BigDecimal.valueOf(349.99));
        consoleUpdate.setQuantity(1);

        Console consoleIExpect = new Console();
        consoleIExpect.setConsole_id(consoleAfterInsert.getConsole_id());
        consoleIExpect.setModel("Playstation 4");
        consoleIExpect.setManufacturer("Sony");
        consoleIExpect.setMemory_amount("1TB");
        consoleIExpect.setProcessor("sony2012");
        consoleIExpect.setPrice(BigDecimal.valueOf(349.99));
        consoleIExpect.setQuantity(1);

        //act
        consoleDao.updateConsole(consoleUpdate);
        Console consoleIGot = consoleDao.getConsole(consoleIExpect.getConsole_id());

        //assert
        assertEquals(consoleIExpect, consoleIGot);
    }


}