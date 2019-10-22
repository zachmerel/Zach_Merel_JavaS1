package com.trilogyed.ZachMerelU1M5Summative.dao;

import com.trilogyed.ZachMerelU1M5Summative.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@Repository
public class BookDaoJbdcTemplateImpl implements BookDao {

    private JdbcTemplate jdbcTemplate;

    private static final String GET_ALL_BOOK_SQL =
            "select * from book";
    private static final String DELETE_BOOK_SQL =
            "delete from book where book_id =?";
    private static final String CREATE_BOOK_SQL =
            "insert into book (isbn, publish_date, author_id, title, publisher_id, price)" +
                    "values (?, ?, ?, ?, ?, ?)";
    private static final String GET_BOOK_BY_AUTOR_ID_SQL =
            "select * from book where author_id = ?";
    private static final String GET_BOOK_SQL =
            "select * from book where book_id =?";
    private static final String UPDATE_BOOK_SQL =
            "update book set isbn = ?, publish_date = ?, author_id = ?, title = ?, publisher_id = ?, price = ? ";

    @Autowired
    public BookDaoJbdcTemplateImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public void updateBook(Book book) {
    jdbcTemplate.update(UPDATE_BOOK_SQL,
            book.getIsbn(),
            book.getPublish_date(),
            book.getAuthor_id(),
            book.getTitle(),
            book.getPublisher_id(),
            book.getPrice());
    }

    @Override
    public void deleteBook(int book_id) {
        jdbcTemplate.update(DELETE_BOOK_SQL, book_id);

    }

    @Override
    @Transactional
    public Book addBook(Book book) {
        jdbcTemplate.update(CREATE_BOOK_SQL,
                book.getIsbn(),
                book.getPublish_date(),
                book.getAuthor_id(),
                book.getTitle(),
                book.getPublisher_id(),
                book.getPrice());

        int id = jdbcTemplate.queryForObject(" select last_insert_id()", Integer.class);

        book.setBook_id(id);

        return book;
    }

    @Override
    public Book getBook(int book_id) {
        try{
            return jdbcTemplate.queryForObject(GET_BOOK_SQL, this::mapRowToBook, book_id);
        }catch (EmptyResultDataAccessException erdae){
            System.out.println("There is no book with id " + book_id + "; message: " + erdae.getMessage());
            return null;
        }

    }

    @Override
    public List<Book> getAllBooks() {
        return jdbcTemplate.query(GET_ALL_BOOK_SQL, this::mapRowToBook);
    }

    @Override
    public List<Book> getBookByAuthor(int author_id) {
        return jdbcTemplate.query(GET_BOOK_BY_AUTOR_ID_SQL, this::mapRowToBook, author_id);
    }

    private Book mapRowToBook(ResultSet rs, int rowNum) throws SQLException {
        Book book = new Book();
        book.setBook_id(rs.getInt("book_id"));
        book.setIsbn(rs.getString("isbn"));
        book.setPublish_date(LocalDate.parse(rs.getString("publish_date")));
        book.setAuthor_id(rs.getInt("author_id"));
        book.setTitle(rs.getString("title"));
        book.setPublisher_id(rs.getInt("publisher_id"));
        book.setPrice(rs.getBigDecimal("price"));

        return book;
    }
}
