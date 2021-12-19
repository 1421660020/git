package com.company;

/**
 * @Author Administrator
 * @Date 2021/7/30 7:59
 * @Version 1.0
 */

public class aa {
     private int a;
     private int b;

    public int getA() {
        return a;
    }
    public void setA(int a) {
        this.a = a;
    }

    public  aa() {
        System.out.println("aaa");
    }

    public aa(int a, int b) {
        this();
        this.a = a;
        this.b = b;

    }

    /**
     * 显示a，b值
     * @param s 是字符串
     */
    public void  show (String s){
        System.out.println(this.a+"\t"+b+s);
        s+="234";
    }

    public static void main(String[] args) {
        aa a=new aa(1,2);
        String s=new String("123");


        a.show(s);

        System.out.println(s);

    }

}
