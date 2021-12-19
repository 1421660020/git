package com.web.dao.imp;

import com.web.bean.OrderItem;
import com.web.dao.OrderItemDao;

/**
 * @Author Administrator
 * @Date 2021/12/7 1:36
 * @Version 1.0
 */
public class OrderItemDaoImpl extends BaseDao implements OrderItemDao {

    @Override
    public int saveOrderItem(OrderItem orderItem) {
        String sql = "insert into `t_order_item` (`name`,`count`,`price`,`total_price`,`order_id`) values(?,?,?,?,?) ";
        return update(sql, orderItem.getName(), orderItem.getCount(), orderItem.getPrice(), orderItem.getTotalPrice(), orderItem.getOrderId());
    }
}
