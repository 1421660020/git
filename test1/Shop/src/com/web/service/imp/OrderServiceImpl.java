package com.web.service.imp;

import com.web.bean.*;
import com.web.dao.BookDao;
import com.web.dao.OrderDao;
import com.web.dao.OrderItemDao;
import com.web.dao.imp.BookDaoImpl;
import com.web.dao.imp.OrderDaoImpl;
import com.web.dao.imp.OrderItemDaoImpl;
import com.web.service.OrderService;

import java.util.Date;
import java.util.Map;

/**
 * @Author Administrator
 * @Date 2021/12/7 2:06
 * @Version 1.0
 */
public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao = new OrderDaoImpl();
    private OrderItemDao orderItemDao = new OrderItemDaoImpl();
    private BookDao bookDao = new BookDaoImpl();

    @Override
    public String createOrder(Cart cart, Integer userId) {
        //生成唯一订单号
        String orderId = System.currentTimeMillis() + "" + userId;
        //保存订单
        orderDao.saveOrder(new Order(orderId, new Date(), userId, 0, cart.getTotalPrice()));
        for (Map.Entry<Integer, CartItem> m : cart.getItems().entrySet()) {
            CartItem cartItem = m.getValue();
            //保存订单项
            orderItemDao.saveOrderItem(new OrderItem(null, cartItem.getName(), cartItem.getCount(), cartItem.getPrice(), orderId));
            //更新库存和销量
            Book book = bookDao.queryBookById(cartItem.getId());
            book.setSales(book.getSales() + cartItem.getCount());
            book.setStock(book.getStock() - cartItem.getCount());
            bookDao.updateBook(book);
        }
        // 清空购物车
        cart.clear();
        return orderId;
    }
}
