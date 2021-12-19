package com.web.dao;

import com.web.bean.Book;

import java.util.List;

/**
 * @Author Administrator
 * @Date 2021/12/1 22:36
 * @Version 1.0
 */
public interface BookDao {

    int addBook(Book book);

    int deleteBookById(Integer id);

    int updateBook(Book book);

    Book queryBookById(Integer id);

    List<Book> queryBooks();


}
