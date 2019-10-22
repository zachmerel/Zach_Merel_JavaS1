package com.trilogyed.ZachMerelU1M5Summative.dao;

import com.trilogyed.ZachMerelU1M5Summative.model.Author;
import com.trilogyed.ZachMerelU1M5Summative.model.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PublisherDaoJdbcTemplateImpl implements PublisherDao {

    private JdbcTemplate jdbcTemplate;


    private static final String GET_ALL_PUBLISHER_SQL =
            "select * from publisher";
    private static final String DELETE_PUBLISHER_SQL =
            "delete from publisher where publisher_id = ?";
    private static final String CREATE_PUBLISHER_SQL =
            "insert into publisher(name, street, city, state, postal_code, phone, email)" +
                    "values (?, ?, ?, ?, ?, ?, ?)";
    private static final String GET_PUBLISHER_SQL =
            "select * from publisher where publisher_id = ?";
    private static final String UPDATE_PUBLISHER_SQL =
            "update publisher set name =?, street =?, city =? , state = ?, postal_code = ?, phone = ?, email =?";


    @Autowired
    public PublisherDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void updatePublisher(Publisher publisher) {
        jdbcTemplate.update(UPDATE_PUBLISHER_SQL,
                publisher.getName(),
                publisher.getStreet(),
                publisher.getCity(),
                publisher.getState(),
                publisher.getPostal_code(),
                publisher.getPhone(),
                publisher.getEmail()
        );

    }

    @Override

    public void deletePublisher(int publisherId) {
        jdbcTemplate.update(DELETE_PUBLISHER_SQL, publisherId);

    }

    @Override
    @Transactional
    public Publisher addPublisher(Publisher publisher) {
        jdbcTemplate.update(CREATE_PUBLISHER_SQL,
                publisher.getName(),
                publisher.getStreet(),
                publisher.getCity(),
                publisher.getState(),
                publisher.getPostal_code(),
                publisher.getPhone(),
                publisher.getEmail()
        );

        int id = jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);

        publisher.setPublisher_id(id);

        return publisher;
    }

    @Override
    public Publisher getPublisher(int publisherId) {
        try {
            return jdbcTemplate.queryForObject(GET_PUBLISHER_SQL, this::mapRowToPublisher, publisherId);
        } catch (EmptyResultDataAccessException erdae) {
            System.out.println("There is no publisher with id " + publisherId + "; message: " + erdae.getMessage());
            return null;
        }
    }

    @Override
    public List<Publisher> getAllPublishers() {
        return jdbcTemplate.query(GET_ALL_PUBLISHER_SQL, this::mapRowToPublisher);
    }

    private Publisher mapRowToPublisher(ResultSet rs, int rowNum) throws SQLException {
        Publisher publisher = new Publisher();
        publisher.setPublisher_id(rs.getInt("publisher_id"));
        publisher.setName(rs.getString("name"));
        publisher.setStreet(rs.getString("street"));
        publisher.setCity(rs.getString("city"));
        publisher.setState(rs.getString("state"));
        publisher.setPostal_code(rs.getString("postal_code"));
        publisher.setPhone(rs.getString("phone"));
        publisher.setEmail(rs.getString("email"));

        return publisher;
    }
}
