package com.epam.mentoring.book.web;

import com.epam.mentoring.book.dao.BookDao;
import com.epam.mentoring.book.dao.impl.DaoFactory;
import com.epam.mentoring.book.model.Book;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author Mikhail_Chen-Len-Son@epam.com
 */
public class TestBookServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BookDao bookDao = DaoFactory.getBookDao();
        List<Book> books = bookDao.getAll();
        req.setAttribute("books", books);
        getServletContext().getRequestDispatcher("/books.jsp").forward(req, resp);
    }
}
