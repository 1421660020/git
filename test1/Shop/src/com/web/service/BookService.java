package com.web.service;

import com.web.bean.Book;

import java.util.List;

/**
 * @Author Administrator
 * @Date 2021/12/1 23:09
 * @Version 1.0
 */
public interface BookService {
    int addBook(Book book);

    int deleteBookById(Integer id);

    int updateBook(Book book);

    Book queryBookById(Integer id);

    List<Book> queryBooks();

}
