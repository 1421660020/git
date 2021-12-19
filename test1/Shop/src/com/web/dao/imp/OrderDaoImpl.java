package com.web.dao.imp;

import com.web.bean.Order;
import com.web.dao.OrderDao;

/**
 * @Author Administrator
 * @Date 2021/12/7 1:35
 * @Version 1.0
 */
public class OrderDaoImpl extends BaseDao implements OrderDao {
    @Override
    public int saveOrder(Order order) {
        String sql = "insert into `t_order` (`order_id`,`create_time`,`price`,`status`,`user_id`)values(?,?,?,?,?)";
        return update(sql, order.getOrderId(), order.getCreateTime(), order.getPrice(), order.getStatus(), order.getUserId());
    }
}
