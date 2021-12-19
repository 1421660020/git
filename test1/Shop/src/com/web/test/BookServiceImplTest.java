package com.web.test;

import com.web.bean.Book;
import com.web.service.BookService;
import com.web.service.imp.BookServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Author Administrator
 * @Date 2021/12/1 23:20
 * @Version 1.0
 */
public class BookServiceImplTest {
    private BookService bookService = new BookServiceImpl();

    @Test
    public void addBook() {
        System.out.println(bookService.addBook(new Book(null, "中", new BigDecimal(20), "a1dmin", 99, 1, "/static/img/m.jpg")));
    }

    @Test
    public void deleteBookById() {
        System.out.println(bookService.deleteBookById(21));
    }

    @Test
    public void updateBook() {
        System.out.println(bookService.updateBook(new Book(21, "神", new BigDecimal(10), "admin", 99, 1, "/static/img/m.jpg")));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookService.queryBookById(21));
    }

    @Test
    public void queryBooks() {
        List<Book> books = bookService.queryBooks();
        for (Book book : books) {
            System.out.println(book);
        }
    }
}