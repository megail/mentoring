package com.epam.mentoring.book.dao;

import com.epam.mentoring.book.dao.impl.BookSqlMapDao;
import com.epam.mentoring.book.model.Book;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author Mikhail_Chen-Len-Son@epam.com
 */
public class BookDaoTest {
    private static SqlSessionFactory sqlSessionFactory;
    private BookDao dao = new BookSqlMapDao(sqlSessionFactory);

    @BeforeClass
    public static void setUp() throws IOException {
        Reader reader = Resources.getResourceAsReader("com/epam/mentoring/book/mybatis-test-config.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
    }

    @Test
    public void testGetAll() {
        List<Book> books = dao.getAll();
        assertNotNull(books);
        assertEquals(3, books.size());
    }

    @Test
    public void testGetById() {
        Book book = dao.getById(3);
        assertNotNull(book);
        assertEquals("Excellent Book", book.getTitle());
        assertNotNull(book.getAuthors());
        assertEquals(2, book.getAuthors().size());
    }
}
