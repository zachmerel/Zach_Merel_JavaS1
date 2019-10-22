package com.trilogyed.ZachMerelU1M5Summative.dao;

import com.trilogyed.ZachMerelU1M5Summative.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class AuthorDaoJbdcTemplateImpl implements AuthorDao {

    private JdbcTemplate jdbcTemplate;

    private static final String GET_ALL_AUTHOR_SQL =
            "select * from author";
    private static final String DELETE_AUTHOR_SQL =
            "delete from author where author_id = ?";
    private static final String CREATE_AUTHOR_SQL =
            "insert into author(first_name, last_name, street, city, state, postal_code, phone, email)"  +
                    "values (?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String GET_AUTHOR_SQL =
            "select * from author where author_id = ?";
    private static final String UPDATE_AUTHOR_SQL =
            "update author set first_name =?, last_name =?, street =?, city =? , state = ?, postal_code = ?, phone = ?, email =?";

    @Autowired
    public AuthorDaoJbdcTemplateImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public void updateAuthor(Author author) {
    jdbcTemplate.update(UPDATE_AUTHOR_SQL,
            author.getFirst_name(),
            author.getLast_name(),
            author.getStreet(),
            author.getCity(),
            author.getState(),
            author.getPostal_code(),
            author.getPhone(),
            author.getEmail()

            );
    }

    @Override
    public void deleteAuthor(int author_id) {
    jdbcTemplate.update(DELETE_AUTHOR_SQL, author_id);
    }

    @Override
    @Transactional
    public Author addAuthor(Author author) {
         jdbcTemplate.update(CREATE_AUTHOR_SQL,
                author.getFirst_name(),
                author.getLast_name(),
                author.getStreet(),
                author.getCity(),
                author.getState(),
                author.getPostal_code(),
                author.getPhone(),
                author.getEmail()
        );

        int id = jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);

        author.setAuthor_id(id);

        return  author;
    }

    @Override
    public Author getAuthor(int author_id) {
        try{
            return jdbcTemplate.queryForObject(GET_AUTHOR_SQL, this::mapRowToAuthor, author_id);
        }catch(EmptyResultDataAccessException erdae){
            System.out.println("There is no author with id " + author_id + "; message: " + erdae.getMessage());
            return null;
        }
    }

    @Override
    public List<Author> getAllAuthors() {
        return jdbcTemplate.query(GET_ALL_AUTHOR_SQL, this::mapRowToAuthor);
    }

    private Author mapRowToAuthor(ResultSet rs, int rowNum) throws SQLException {
        Author author = new Author();
        author.setAuthor_id(rs.getInt("author_id"));
        author.setFirst_name(rs.getString("first_name"));
        author.setLast_name(rs.getString("last_name"));
        author.setStreet(rs.getString("street"));
        author.setCity(rs.getString("city"));
        author.setState(rs.getString("state"));
        author.setPostal_code(rs.getString("postal_code"));
        author.setPhone(rs.getString("phone"));
        author.setEmail(rs.getString("email"));

        return author;
    }
}
