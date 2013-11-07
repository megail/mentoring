package com.epam.mentoring.book.dao;

import com.epam.mentoring.book.model.Book;

import java.util.List;

/**
 * @author Mikhail_Chen-Len-Son@epam.com
 */
public interface BookDao {
    List<Book> getAll();
    Book getById(long id);
}
