package com.trilogyed.ZachMerelU1M5Summative.dao;

import com.trilogyed.ZachMerelU1M5Summative.model.Author;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AuthorDao {
    void updateAuthor(Author author);
    void deleteAuthor(int author_id);
    Author addAuthor(Author author);
    Author getAuthor(int author_id);
    List<Author> getAllAuthors();
}
