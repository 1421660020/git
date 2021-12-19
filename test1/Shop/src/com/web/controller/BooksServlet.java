package com.web.controller;

import com.web.bean.Book;
import com.web.bean.User;
import com.web.service.BookService;
import com.web.service.UserSerice;
import com.web.service.imp.BookServiceImpl;
import com.web.service.imp.UserServiceImp;
import com.web.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Author Administrator
 * @Date 2021/12/2 1:12
 * @Version 1.0
 */
public class BooksServlet extends BaseServlet {
    private BookService bookService = new BookServiceImpl();
    private UserSerice userService = new UserServiceImp();

    /**
     * 显示所有图书
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void showAllBooks(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("showAllBooks被调用");
        List<Book> books = bookService.queryBooks();
        req.setAttribute("books", books);
        req.getRequestDispatcher("/page/jsp/manager/books.jsp?isChange=true").forward(req, resp);
    }

    protected void showBooks(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("showBooks被调用");
        List<Book> books = bookService.queryBooks();
        req.setAttribute("books", books);
        req.getRequestDispatcher("/page/jsp/manager/showBook.jsp?isChange=true").forward(req, resp);
    }

    /**
     * 显示所有用户
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void showAllUsers(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users = userService.showAllUser();
        req.setAttribute("users", users);
        req.getRequestDispatcher("/page/jsp/manager/users.jsp").forward(req, resp);
    }


    /**
     * 转到图书页面
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void updateBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("updateBook方法被调用");
        Book book = bookService.queryBookById(Integer.parseInt(request.getParameter("id")));
        //回显图书信息
        request.setAttribute("update_book", book);
        request.getRequestDispatcher("/page/jsp/manager/update_book.jsp").forward(request, response);
    }

    /**
     * 删除图书信息
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void deleteBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("调用了删除图书");
        bookService.deleteBookById(Integer.parseInt(request.getParameter("id")));
        List<Book> books = bookService.queryBooks();
        request.setAttribute("books", books);
        request.getRequestDispatcher("/page/jsp/manager/books.jsp?isChange=true").forward(request, response);
    }

    /**
     * 修改图书信息
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void updateSuccess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Book book = new Book();
        WebUtils.changeParaToBean(request.getParameterMap(), book);
        System.out.println(book);
        bookService.updateBook(book);
        List<Book> books = bookService.queryBooks();
        request.setAttribute("books", books);
        request.getRequestDispatcher("/page/jsp/manager/books.jsp?isChange=true").forward(request, response);
    }

    /**
     * 添加图书信息
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void insertBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //表单项类
        Book book = new Book();
        WebUtils.changeParaToBean(request.getParameterMap(), book);
        bookService.addBook(book);
        List<Book> books = bookService.queryBooks();
        request.setAttribute("books", books);
        request.getRequestDispatcher("/page/jsp/manager/books.jsp?isChange=true").forward(request, response);
    }

}
