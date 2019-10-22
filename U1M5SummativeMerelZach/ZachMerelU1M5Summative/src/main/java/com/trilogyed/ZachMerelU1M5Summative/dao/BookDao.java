package com.trilogyed.ZachMerelU1M5Summative.dao;

import com.trilogyed.ZachMerelU1M5Summative.model.Book;
import java.util.List;

public interface BookDao {
    void updateBook(Book book);
    void deleteBook(int book_id);
    Book addBook(Book book);
    Book getBook(int book_id);
    List<Book> getAllBooks();
    List<Book> getBookByAuthor(int author_id);
}
