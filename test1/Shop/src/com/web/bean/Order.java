package com.web.bean;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author Administrator
 * @Date 2021/12/7 0:55
 * @Version 1.0
 */
public class Order {
    private String orderId;
    private Date createTime;
    private Integer userId;
    // 0未发货，1已发货，2表示已签收
    private Integer status = 0;
    private BigDecimal price;

    public Order() {
    }

    public Order(String orderId, Date createTime, Integer userId, Integer status, BigDecimal price) {
        this.orderId = orderId;
        this.createTime = createTime;
        this.userId = userId;
        this.status = status;
        this.price = price;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", createTime=" + createTime +
                ", userId=" + userId +
                ", status=" + status +
                ", price=" + price +
                '}';
    }
}
