package com.web.test;

import com.web.bean.Order;
import com.web.dao.OrderDao;
import com.web.dao.imp.OrderDaoImpl;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author Administrator
 * @Date 2021/12/7 1:50
 * @Version 1.0
 */
public class OrderDaoImplTest {
    OrderDao orderDao=new OrderDaoImpl();

    @Test
    public void saveOrder() {
        Order order = new Order("1123", new Date(), 1, 0, new BigDecimal(20));
        orderDao.saveOrder(order);
    }
}