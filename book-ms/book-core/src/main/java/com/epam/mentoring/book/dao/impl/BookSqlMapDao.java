package com.epam.mentoring.book.dao.impl;

import com.epam.mentoring.book.dao.BookDao;
import com.epam.mentoring.book.model.Book;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @author Mikhail_Chen-Len-Son@epam.com
 */
public class BookSqlMapDao implements BookDao {
    private final SqlSessionFactory sessionFactory;

    public BookSqlMapDao(SqlSessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Book> getAll() {
        final SqlSession session = sessionFactory.openSession();
        try {
            return session.selectList("Book.getAll");
        } finally {
            session.close();
        }
    }

    @Override
    public Book getById(long id) {
        final SqlSession session = sessionFactory.openSession();
        try {
            return session.selectOne("Book.getById", id);
        } finally {
            session.close();
        }
    }
}
