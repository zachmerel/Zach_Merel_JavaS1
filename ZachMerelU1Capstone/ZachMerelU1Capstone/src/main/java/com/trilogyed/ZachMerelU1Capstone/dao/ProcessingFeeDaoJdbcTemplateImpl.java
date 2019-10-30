package com.trilogyed.ZachMerelU1Capstone.dao;

import com.trilogyed.ZachMerelU1Capstone.model.ProcessingFee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class ProcessingFeeDaoJdbcTemplateImpl implements ProcessingFeeDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ProcessingFeeDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static final String GET_PROCESSING_FEE_BY_PRODUCT_TYPE_SQL =
            "select * from processing_fee where product_type =?";

    @Override
    public ProcessingFee getProcessingFee(String product_type) {
        try{
            return jdbcTemplate.queryForObject(GET_PROCESSING_FEE_BY_PRODUCT_TYPE_SQL, this::mapRowToProcessingFee, product_type);
        }catch(EmptyResultDataAccessException erdae){
            System.out.println("There is no processing fee associated with that product type " + product_type + "; message: " + erdae.getMessage());
            return null;
        }
    }

    private ProcessingFee mapRowToProcessingFee (ResultSet rs, int rowNum) throws SQLException {
        ProcessingFee processingFee = new ProcessingFee();
        processingFee.setProduct_type(rs.getString("product_type"));
        processingFee.setFee(rs.getBigDecimal("fee"));

        return processingFee;
    }
}
