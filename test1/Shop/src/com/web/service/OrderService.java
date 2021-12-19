package com.web.service;

import com.web.bean.Cart;

/**
 * @Author Administrator
 * @Date 2021/12/7 2:04
 * @Version 1.0
 */
public interface OrderService {
    String createOrder(Cart cart, Integer userId);
}
