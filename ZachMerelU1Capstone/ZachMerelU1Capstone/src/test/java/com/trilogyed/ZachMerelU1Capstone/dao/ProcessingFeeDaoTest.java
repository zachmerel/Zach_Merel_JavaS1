package com.trilogyed.ZachMerelU1Capstone.dao;

import com.trilogyed.ZachMerelU1Capstone.model.ProcessingFee;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ProcessingFeeDaoTest {

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
    }

    @Test
    public void getProcessingFee() {
        //arrange
        ProcessingFee processingFeeIExpect = new ProcessingFee();
        processingFeeIExpect.setFee(BigDecimal.valueOf(14.99));
        processingFeeIExpect.setProduct_type("Consoles");

        //act
        ProcessingFee processingFeeIGot = processingFeeDao.getProcessingFee("Consoles");

        //assert
        assertEquals(processingFeeIExpect, processingFeeIGot);


    }
}