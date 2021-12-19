package com.web.test;

import com.web.bean.OrderItem;
import com.web.dao.OrderItemDao;
import com.web.dao.imp.OrderItemDaoImpl;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @Author Administrator
 * @Date 2021/12/7 1:49
 * @Version 1.0
 */
public class OrderItemDaoImplTest {
    private OrderItemDao orderItemDao=new OrderItemDaoImpl();
    @Test
    public void saveOrderItem() {
        OrderItem orderItem=new OrderItem(1,"火腿",3,new BigDecimal(10),"123");
        orderItemDao.saveOrderItem(orderItem);
    }
}