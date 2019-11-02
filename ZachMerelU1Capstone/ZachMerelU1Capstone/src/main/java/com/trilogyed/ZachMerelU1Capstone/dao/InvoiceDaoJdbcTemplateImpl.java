package com.trilogyed.ZachMerelU1Capstone.dao;

import com.trilogyed.ZachMerelU1Capstone.model.Console;
import com.trilogyed.ZachMerelU1Capstone.model.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class InvoiceDaoJdbcTemplateImpl implements InvoiceDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public InvoiceDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static final String CREATE_INVOICE_SQL =
            "insert into invoice (name, street, city, state, zipcode,item_type, item_id, quantity, unit_price, subtotal, tax, processing_fee, total) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";

    @Override
    public Invoice addInvoice(Invoice invoice) {
        jdbcTemplate.update(CREATE_INVOICE_SQL,
                invoice.getName(),
                invoice.getStreet(),
                invoice.getCity(),
                invoice.getState(),
                invoice.getZipcode(),
                invoice.getItem_type(),
                invoice.getItem_id(),
                invoice.getQuantity(),
                invoice.getUnit_price(),
                invoice.getSubtotal(),
                invoice.getTax(),
                invoice.getProcessing_fee(),
                invoice.getTotal()
        );

        int id = jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);

        invoice.setId(id);

        return invoice;
    }
}
