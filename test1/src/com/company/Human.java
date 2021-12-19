package com.company;

public class Human {
    private String name;
    private char sex;
    private String address;

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", sex=" + sex +
                ", address='" + address + '\'' +
                '}';
    }

    public static void main(String[] args) {
        new aa().show("a");
        Human human=new Human();
        human.setName("习近平");
        human.setSex('男');
        human.setAddress("中国中南海");
        System.out.println( human.toString());
    }
}
