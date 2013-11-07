package com.epam.mentoring.book.dao.impl;

import com.epam.mentoring.book.dao.BookDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class DaoFactory {
    private static final BookDao bookDao;

    static {
        try {
            final String resource = "com/epam/mentoring/book/mybatis-config.xml";
            final Reader reader = Resources.getResourceAsReader(resource);
            final SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

            bookDao = new BookSqlMapDao(sqlSessionFactory);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static BookDao getBookDao() {
        return bookDao;
    }
}
