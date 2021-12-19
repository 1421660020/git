package com.web.controller;

import com.web.bean.Book;
import com.web.bean.Cart;
import com.web.bean.CartItem;
import com.web.service.BookService;
import com.web.service.imp.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author Administrator
 * @Date 2021/12/7 2:50
 * @Version 1.0
 */
public class CartServlet extends BaseServlet {
    private BookService bookService = new BookServiceImpl();

    protected void addCartItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer id = Integer.parseInt(req.getParameter("id"));
        System.out.println(id);
        Book book = bookService.queryBookById(id);
        CartItem cartItem = new CartItem(book.getId(), book.getName(), 1, book.getPrice());
        Cart cart = new Cart();
        cart.addItem(cartItem);
        req.getSession().setAttribute("cart", cart);
        req.getRequestDispatcher("/page/jsp/manager/showBook.jsp?isChange=false").forward(req, resp);
    }


}
