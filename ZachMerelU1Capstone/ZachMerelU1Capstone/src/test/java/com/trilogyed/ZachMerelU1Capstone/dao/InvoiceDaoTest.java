package com.trilogyed.ZachMerelU1Capstone.dao;

import com.trilogyed.ZachMerelU1Capstone.model.Invoice;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class InvoiceDaoTest {

    @Autowired
    private InvoiceDao invoiceDao;


    @Test
    public void shouldAddNewInvoice() {
        //arrange
        Invoice invoiceToInsert = new Invoice();
        invoiceToInsert.setName("Zach Merel");
        invoiceToInsert.setStreet("Addison Ave");
        invoiceToInsert.setCity("Chicago");
        invoiceToInsert.setState("IL");
        invoiceToInsert.setZipcode("60613");
        invoiceToInsert.setItem_type("Game");
        invoiceToInsert.setItem_id(1);
        invoiceToInsert.setQuantity(1);
        invoiceToInsert.setUnit_price(BigDecimal.valueOf(20.00));
        invoiceToInsert.setSubtotal(BigDecimal.valueOf(20.00));
        invoiceToInsert.setTax(BigDecimal.valueOf(1.0));
        invoiceToInsert.setProcessing_fee(BigDecimal.valueOf(1.49));
        invoiceToInsert.setTotal(BigDecimal.valueOf(22.49));

        //act
        Invoice invoiceAfterInsert = invoiceDao.addInvoice(invoiceToInsert);
        invoiceAfterInsert.setId(invoiceAfterInsert.getId());

        //assert
        assertEquals(invoiceToInsert, invoiceAfterInsert);
    }
}
