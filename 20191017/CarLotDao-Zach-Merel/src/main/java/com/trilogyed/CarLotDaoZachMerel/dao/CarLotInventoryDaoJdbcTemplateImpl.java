package com.trilogyed.CarLotDaoZachMerel.dao;

import com.trilogyed.CarLotDaoZachMerel.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CarLotInventoryDaoJdbcTemplateImpl implements CarLotInventoryDao {

    //prepared statements for the methods
    private static final String DELETE_CAR_SQL =
            "delete from car where id =?";

    private static final String CREATE_CAR_SQL =
            "insert into car(make,model,year,color) values(? ,? ,? ,? )";

    private static final String SELECT_CARS_BY_MAKE_SQL =
            "select * from car where make = ?";

    private static final String SELECT_CARS_BY_COLOR_SQL =
            "select * from car where color = ?";

    private static final String UPDATE_CAR_SQL =
            "update car set  make =?, model =?, year =?, color =? where id = ?";

    private static final String SELECT_CAR_SQL =
            "select * from car where id =?";

    private static final String SELECT_ALL_CARS_SQL =
            "select * from car";

    private JdbcTemplate jdbcTemplate;


    @Autowired
    public CarLotInventoryDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public Car getCar(int id) {
        try {
            return jdbcTemplate.queryForObject(SELECT_CAR_SQL, this::mapRowToCar, id);
        } catch (EmptyResultDataAccessException erdae) {
            System.out.println("Caught an exception. Here is the message: " + erdae.getMessage());
            return null;
        }
    }

    @Override
    public List<Car> getAllCars() {
        return jdbcTemplate.query(SELECT_ALL_CARS_SQL, this::mapRowToCar);
    }

    @Override
    public void deleteCar(int id) {
        jdbcTemplate.update(DELETE_CAR_SQL, id);
    }

    @Override
    public void updateCar(Car car) {
        jdbcTemplate.update(UPDATE_CAR_SQL,
                car.getMake(),
                car.getModel(),
                car.getYear(),
                car.getColor(),
                car.getId()
        );
    }

    @Override
    @Transactional
    public Car addCar(Car car) {
        jdbcTemplate.update(CREATE_CAR_SQL,
                car.getMake(),
                car.getModel(),
                car.getYear(),
                car.getColor());
        int id = jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);

        car.setId(id);
        return car;
    }

    @Override
    public List<Car> getCarByMake(String make) {
        return jdbcTemplate.query(SELECT_CARS_BY_MAKE_SQL, this::mapRowToCar, make);
    }

    @Override
    public List<Car> getCarByColor(String color) {
        return jdbcTemplate.query(SELECT_CARS_BY_COLOR_SQL, this::mapRowToCar, color);

    }

    private Car mapRowToCar(ResultSet rs, int rowNum) throws SQLException {
        Car car = new Car();
        car.setId(rs.getInt("id"));
        car.setMake(rs.getString("make"));
        car.setModel(rs.getString("model"));
        car.setYear(rs.getString("year"));
        car.setColor(rs.getString("color"));

        return car;
    }
}
