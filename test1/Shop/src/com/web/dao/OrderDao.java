package com.web.dao;

import com.web.bean.Order;

/**
 * @Author Administrator
 * @Date 2021/12/7 1:34
 * @Version 1.0
 */
public interface OrderDao {

    int saveOrder(Order order);
}
