package com.web.dao;

import com.web.bean.OrderItem;

/**
 * @Author Administrator
 * @Date 2021/12/7 1:24
 * @Version 1.0
 */
public interface OrderItemDao {
    int saveOrderItem(OrderItem orderItem);
}
