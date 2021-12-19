package com.web.bean;

import java.math.BigDecimal;

/**
 * @Author Administrator
 * @Date 2021/12/1 22:29
 * @Version 1.0
 */
public class Book {
    //id
    private Integer id;
    //图书名
    private String name;
    //价格
    private BigDecimal price;
    //作者
    private String author;
    //销售量
    private int sales;
    //余量
    private int stock;
    //封面路径
    private String imgPath = "static/img/default.jpg";

    public Book() {
    }

    public Book(Integer id, String name, BigDecimal price, String author, int sales, int stock, String imgpath) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.author = author;
        this.sales = sales;
        this.stock = stock;
        this.imgPath = imgpath;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getImgpath() {
        return imgPath;
    }

    public void setimgpath(String imgpath) {
        this.imgPath = imgpath;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", author='" + author + '\'' +
                ", sales=" + sales +
                ", stock=" + stock +
                ", imgpath='" + imgPath + '\'' +
                '}';
    }
}
