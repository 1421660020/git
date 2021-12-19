package com.web.test;

import com.web.bean.Cart;
import com.web.bean.CartItem;
import com.web.service.OrderService;
import com.web.service.imp.OrderServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @Author Administrator
 * @Date 2021/12/7 2:32
 * @Version 1.0
 */
public class OrderServiceImplTest {
    OrderService orderService = new OrderServiceImpl();

    @Test
    public void createOrder() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(4, "木虚肉盖饭1", 1, new BigDecimal(16)));
        orderService.createOrder(cart, 1);
    }
}