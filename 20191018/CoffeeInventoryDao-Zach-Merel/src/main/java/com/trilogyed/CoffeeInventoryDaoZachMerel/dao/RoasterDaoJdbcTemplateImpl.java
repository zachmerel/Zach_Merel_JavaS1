package com.trilogyed.CoffeeInventoryDaoZachMerel.dao;

import com.trilogyed.CoffeeInventoryDaoZachMerel.model.Roaster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class RoasterDaoJdbcTemplateImpl implements RoasterDao{

    //prepared statements
    private static final String DELETE_ROASTER_SQL =
            "delete from roaster where roaster_id = ?";
    private static final String CREATE_ROASTER_SQL =
            "insert into roaster(name,street,city,state,postal_code,phone,email,note) values (?, ?, ?, ?, ?, ?, ? , ?)";
    private static final String UPDATE_ROASTER_SQL =
            "update roaster set name =?, street =?, city =?, state =?, postal_code =?, phone =?, email =?, note =?";
    private static final String SELECT_ROASTER_SQL =
            "select * from roaster where roaster_id =?";
    private static final String SELECT_ALL_ROASTERS_SQL =
            "select * from roaster";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public RoasterDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public Roaster getRoaster(int id) {
        try{
            return jdbcTemplate.queryForObject(SELECT_ROASTER_SQL, this ::mapRowToRoaster, id);
        }catch(EmptyResultDataAccessException erdae){
            System.out.println("Caught an exception. Here's the message: " + erdae.getMessage());
            return null;
        }
    }

    @Override
    public List<Roaster> getAllRoasters() {
        return jdbcTemplate.query(SELECT_ALL_ROASTERS_SQL, this::mapRowToRoaster);
    }

    @Override
    public void deleteRoaster(int id) {
        jdbcTemplate.update(DELETE_ROASTER_SQL,id);

    }

    @Override
    public void updateRoaster(Roaster roaster) {
        jdbcTemplate.update(UPDATE_ROASTER_SQL,
                roaster.getName(),
                roaster.getStreet(),
                roaster.getCity(),
                roaster.getState(),
                roaster.getPostal_code(),
                roaster.getPhone(),
                roaster.getEmail(),
                roaster.getNote()
        );
    }

    @Override
    @Transactional
    public Roaster addRoaster(Roaster roaster) {
        jdbcTemplate.update(CREATE_ROASTER_SQL,
                roaster.getName(),
                roaster.getStreet(),
                roaster.getCity(),
                roaster.getState(),
                roaster.getPostal_code(),
                roaster.getPhone(),
                roaster.getEmail(),
                roaster.getNote());

        int id = jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);

        roaster.setRoaster_id(id);

        return roaster;
    }

    private Roaster mapRowToRoaster (ResultSet rs, int rowNum) throws SQLException {
        Roaster roast = new Roaster();

        roast.setRoaster_id(rs.getInt("roaster_id"));
        roast.setName(rs.getString("name"));
        roast.setStreet(rs.getString("street"));
        roast.setCity(rs.getString("city"));
        roast.setState(rs.getString("state"));
        roast.setPostal_code(rs.getString("postal_code"));
        roast.setPhone(rs.getString("phone"));
        roast.setEmail(rs.getString("email"));
        roast.setNote(rs.getString("note"));

        return roast;
    }
}
