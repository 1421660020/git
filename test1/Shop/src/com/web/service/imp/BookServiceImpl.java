package com.web.service.imp;

import com.web.bean.Book;
import com.web.dao.BookDao;
import com.web.dao.imp.BookDaoImpl;
import com.web.service.BookService;

import java.util.List;

/**
 * @Author Administrator
 * @Date 2021/12/1 23:13
 * @Version 1.0
 */
public class BookServiceImpl implements BookService {
    private BookDao bookDao = new BookDaoImpl();

    @Override
    public int addBook(Book book) {
        return bookDao.addBook(book);
    }

    @Override
    public int deleteBookById(Integer id) {
        return bookDao.deleteBookById(id);
    }

    @Override
    public int updateBook(Book book) {
        return bookDao.updateBook(book);
    }

    @Override
    public Book queryBookById(Integer id) {
        return bookDao.queryBookById(id);
    }

    @Override
    public List<Book> queryBooks() {
        return bookDao.queryBooks();
    }
}
