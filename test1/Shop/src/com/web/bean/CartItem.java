package com.web.bean;

import java.math.BigDecimal;

/**
 * @Author Administrator
 * @Date 2021/12/7 0:55
 * @Version 1.0
 */
public class CartItem {
    private Integer id;
    private String name;
    //数量
    private Integer count;
    //单价
    private BigDecimal price;
    private BigDecimal totalPrice;

    public CartItem() {
    }

    public CartItem(Integer id, String name, Integer count, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.price = price;
        getTotalPrice();
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
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

    //计算总价
    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice = new BigDecimal(count).multiply(price);
        return totalPrice;
    }


    @Override
    public String toString() {
        return "CartItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", count=" + count +
                ", price=" + price +
                ", totalPrice=" + getTotalPrice() +
                '}';
    }
}
