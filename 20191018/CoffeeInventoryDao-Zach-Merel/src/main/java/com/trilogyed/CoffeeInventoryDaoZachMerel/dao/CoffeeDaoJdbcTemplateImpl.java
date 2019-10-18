package com.trilogyed.CoffeeInventoryDaoZachMerel.dao;

import com.trilogyed.CoffeeInventoryDaoZachMerel.model.Coffee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.relational.core.sql.In;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CoffeeDaoJdbcTemplateImpl implements CoffeeDao {

    //prepared statements
    private static final String DELETE_COFFEE_SQL =
            "delete from coffee where coffee_id =?";
    private static final String CREATE_COFFEE_SQL =
            "insert into coffee ( roaster_id, name, count, unit_price, description, type) values ( ?, ?, ?, ?, ?, ?)";
    private static final String SELECT_COFFEE_BY_TYPE =
            "select * from coffee where type =?";
    private static final String UPDATE_COFFEE_SQL =
            "update coffee set roaster_id =?, name =?, count =?, unit_price =?, description =?, type =?";
    private static final String SELECT_COFFEE_SQL =
            "select * from coffee where coffee_id = ?";
    private static final String SELECT_ALL_COFFEES_SQL =
            "select * from coffee";
    private static final String SELECT_COFFEE_BY_ROASTER_ID =
            "select * from coffee where roaster_id = ?";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CoffeeDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public Coffee getCoffee(int id) {
        try {
            return jdbcTemplate.queryForObject(SELECT_COFFEE_SQL, this::mapRowToCoffee, id);
        } catch (EmptyResultDataAccessException erdae) {
            System.out.println("Caught an excepetion. Here's the message: " + erdae.getMessage());
            return null;
        }
    }

    @Override
    public List<Coffee> getAllCoffee() {
        return jdbcTemplate.query(SELECT_ALL_COFFEES_SQL, this::mapRowToCoffee);
    }

    @Override
    public void deleteCoffee(int id) {
    jdbcTemplate.update(DELETE_COFFEE_SQL, id);
    }

    @Override
    public void updateCoffee(Coffee coffee) {
        jdbcTemplate.update(UPDATE_COFFEE_SQL,
                coffee.getRoaster_id(),
                coffee.getName(),
                coffee.getCount(),
                coffee.getUnit_price(),
                coffee.getDescription(),
                coffee.getType(),
                coffee.getCoffee_id()
        );
    }

    @Override
    public Coffee addCoffee(Coffee coffee) {
        jdbcTemplate.update(CREATE_COFFEE_SQL,
                coffee.getRoaster_id(),
                coffee.getName(),
                coffee.getCount(),
                coffee.getUnit_price(),
                coffee.getDescription(),
                coffee.getType());

        int id = jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);

        coffee.setCoffee_id(id);
        return coffee;
    }

    @Override
    public List<Coffee> getCoffeeByRoaster(int roaster_id) {
        return jdbcTemplate.query(SELECT_COFFEE_BY_ROASTER_ID, this::mapRowToCoffee, roaster_id);
    }

    @Override
    public List<Coffee> getCoffeeByType(String type) {
        return jdbcTemplate.query(SELECT_COFFEE_BY_TYPE, this::mapRowToCoffee, type);
    }

    private Coffee mapRowToCoffee(ResultSet rs, int rowNum) throws SQLException {
        Coffee coffee = new Coffee();

        coffee.setRoaster_id(rs.getInt("roaster_id"));
        coffee.setName(rs.getString("name"));
        coffee.setCount(rs.getInt("count"));
        coffee.setUnit_price(rs.getDouble("unit_price"));
        coffee.setDescription(rs.getString("description"));
        coffee.setType(rs.getString("type"));

        return coffee;
    }
}
