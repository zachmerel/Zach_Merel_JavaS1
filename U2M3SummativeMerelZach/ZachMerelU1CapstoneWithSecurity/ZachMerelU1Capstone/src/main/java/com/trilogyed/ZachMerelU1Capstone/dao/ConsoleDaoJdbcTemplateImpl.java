package com.trilogyed.ZachMerelU1Capstone.dao;

import com.trilogyed.ZachMerelU1Capstone.model.Console;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ConsoleDaoJdbcTemplateImpl implements ConsoleDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ConsoleDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static final String CREATE_CONSOLE_SQL =
            "insert into console (model, manufacturer, memory_amount, processor, price, quantity) values (?,?,?,?,?,?)";
    private static final String GET_CONSOLE_SQL =
            "select * from console where console_id = ?";
    private static final String GET_ALL_CONSOLES_SQL =
            "select * from console";
    private static final String GET_CONSOLE_BY_MANUFACTURER_SQL =
            "select * from console where manufacturer = ?";
    private static final String DELETE_GAME_SQL =
            "delete from console where console_id =?";
    private static final String UPDATE_CONSOLE_SQL =
            "update console set model = ?, manufacturer =?, memory_amount =?, processor = ?, price =?, quantity =?";

    @Override
    public Console addConsole(Console console) {
        jdbcTemplate.update(CREATE_CONSOLE_SQL,
                console.getModel(),
                console.getManufacturer(),
                console.getMemory_amount(),
                console.getProcessor(),
                console.getPrice(),
                console.getQuantity());

        int id = jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);

        console.setConsole_id(id);

        return console;
    }


    @Override
    public Console getConsole(int id) {
        try {
            return jdbcTemplate.queryForObject(GET_CONSOLE_SQL, this::mapRowToConsole, id);
        } catch (EmptyResultDataAccessException erdae) {
            System.out.println("There is no console with id " + id + "; message: " + erdae.getMessage());
            return null;
        }
    }

    @Override
    public List<Console> getAllConsoles() {
        return jdbcTemplate.query(GET_ALL_CONSOLES_SQL, this::mapRowToConsole);
    }

    @Override
    public List<Console> getAllConsolesByManufacturer(String manufacturer) {
        try{
            return jdbcTemplate.query(GET_CONSOLE_BY_MANUFACTURER_SQL, this::mapRowToConsole, manufacturer);
        }catch(EmptyResultDataAccessException erdae){
            System.out.println("There is no console with the manufacturer " + manufacturer + "; message: " + erdae.getMessage());
            return null;
        }
    }

    @Override
    public void updateConsole(Console console) {
    jdbcTemplate.update(UPDATE_CONSOLE_SQL, console.getModel(), console.getManufacturer(), console.getMemory_amount(), console.getProcessor(),console.getPrice(), console.getQuantity());
    }

    @Override
    public void deleteConsole(int id) {
        jdbcTemplate.update(DELETE_GAME_SQL, id);

    }

    private Console mapRowToConsole(ResultSet rs, int rowNum) throws SQLException {
        Console console = new Console();
        console.setConsole_id(rs.getInt("console_id"));
        console.setModel(rs.getString("model"));
        console.setManufacturer(rs.getString("manufacturer"));
        console.setMemory_amount(rs.getString("memory_amount"));
        console.setProcessor(rs.getString("processor"));
        console.setPrice(rs.getBigDecimal("price"));
        console.setQuantity(rs.getInt("quantity"));

        return console;
    }

}
