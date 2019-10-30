package com.trilogyed.ZachMerelU1Capstone.dao;

import com.trilogyed.ZachMerelU1Capstone.model.TShirt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TShirtDaoJdbcTemplateImpl implements TShirtDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public TShirtDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static  final String CREATE_TSHIRT_SQL =
            "insert into t_shirt(size, color, description, price, quantity) values (?,?,?,?,?)";
    private static final String GET_TSHIRT_SQL =
            "select * from t_shirt where t_shirt_id = ?";
    private static final String DELETE_TSHIRT_SQL =
            "delete from t_shirt where t_shirt_id = ?";
    private static final String GET_TSHIRT_BY_COLOR_SQL =
            "select * from t_shirt where color =?";
    private static final String GET_TSHIRT_BY_SIZE_SQL =
            "select * from t_shirt where size =?";
    private static final String UPDATE_TSHIRT_SQL =
            "update t_shirt set size =?, color =?, description =?, price = ?, quantity =?";
    private  static final String GET_ALL_TSHRIRT_SQL =
            "select * from t_shirt";
    @Override
    public TShirt addTShirt(TShirt tShirt) {
        jdbcTemplate.update(CREATE_TSHIRT_SQL,
                tShirt.getSize(),
                tShirt.getColor(),
                tShirt.getDescription(),
                tShirt.getPrice(),
                tShirt.getQuantity());

        int id = jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);

        tShirt.setT_shirt_id(id);

        return tShirt;
    }

    @Override
    public TShirt getTShirt(int id) {
        try{
            return jdbcTemplate.queryForObject(GET_TSHIRT_SQL, this::mapRowToTShirt, id);
        }catch(EmptyResultDataAccessException erdae){
            System.out.println("There is no t-shirt with id " + id + "; message: " + erdae.getMessage());
            return null;
        }
    }

    @Override
    public List<TShirt> getAllTShirts() {
        return jdbcTemplate.query(GET_ALL_TSHRIRT_SQL, this::mapRowToTShirt);
    }

    @Override
    public List<TShirt> getAllTShirtsByColor(String color) {
        try{
            return jdbcTemplate.query(GET_TSHIRT_BY_COLOR_SQL, this::mapRowToTShirt, color);
        }catch(EmptyResultDataAccessException erdae){
            System.out.println("There is no t-shirt with color " + color + "; message: " + erdae.getMessage());
            return null;
        }
    }

    @Override
    public List<TShirt> getAllTShirtsBySize(String size) {
        try{
            return jdbcTemplate.query(GET_TSHIRT_BY_SIZE_SQL, this::mapRowToTShirt, size);
        }catch(EmptyResultDataAccessException erdae){
            System.out.println("There is no t-shirt with size " + size + "; message: " + erdae.getMessage());
            return null;
        }
    }

    @Override
    public void updateTShirt(TShirt tShirt) {
    jdbcTemplate.update(UPDATE_TSHIRT_SQL, tShirt.getSize(), tShirt.getColor(), tShirt.getDescription(), tShirt.getPrice(), tShirt.getQuantity());
    }

    @Override
    public void deleteTShirt(int id) {
        jdbcTemplate.update(DELETE_TSHIRT_SQL, id);

    }

    private  TShirt mapRowToTShirt(ResultSet rs, int rowNum) throws SQLException {
        TShirt tShirt = new TShirt();
        tShirt.setT_shirt_id(rs.getInt("t_shirt_id"));
        tShirt.setSize(rs.getString("size"));
        tShirt.setColor(rs.getString("color"));
        tShirt.setDescription(rs.getString("description"));
        tShirt.setPrice(rs.getBigDecimal("price"));
        tShirt.setQuantity(rs.getInt("quantity"));

        return tShirt;
    }
}
