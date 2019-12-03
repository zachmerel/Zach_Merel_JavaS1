package com.trilogyed.ZachMerelU1Capstone.dao;

import com.trilogyed.ZachMerelU1Capstone.model.StateTaxRate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class TaxesDaoJdbcTemplateImpl implements TaxesDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public TaxesDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    private static final String GET_TAX_RATE_BY_STATE_SQL =
            "select * from sales_tax_rate where state =?";
    @Override
    public StateTaxRate getTaxRate(String state) {
        try{
            return jdbcTemplate.queryForObject(GET_TAX_RATE_BY_STATE_SQL, this::mapRowToStateTaxRate, state);
        }catch(EmptyResultDataAccessException erdae){
            System.out.println("There is no sales tax rate  associated with that state  " + state + "; message: " + erdae.getMessage());
            return null;
        }
    }

    private StateTaxRate mapRowToStateTaxRate (ResultSet rs, int rowNum) throws SQLException {
        StateTaxRate stateTaxRate = new StateTaxRate();
        stateTaxRate.setRate(rs.getBigDecimal("rate"));
        stateTaxRate.setState(rs.getString("state"));

        return stateTaxRate;
    }
}
