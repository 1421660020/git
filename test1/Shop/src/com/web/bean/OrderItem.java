package com.web.bean;

import java.math.BigDecimal;

/**
 * @Author Administrator
 * @Date 2021/12/7 0:55
 * @Version 1.0
 */
public class OrderItem {
    private Integer id;
    private String name;
    //数量
    private Integer count;
    //单价
    private BigDecimal price;
    private String orderId;


    public OrderItem() {
    }

    public OrderItem(Integer id, String name, Integer count, BigDecimal price, String orderId) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.price = price;
        this.orderId = orderId;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    //计算总价
    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice = new BigDecimal(count).multiply(price);
        return totalPrice;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", count=" + count +
                ", price=" + price +
                ", orderId=" + orderId +
                ", totalPrice=" + getTotalPrice() +
                '}';
    }
}
