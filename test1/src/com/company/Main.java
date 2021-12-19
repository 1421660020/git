package com.company;

import org.junit.Test;

import java.util.Comparator;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

interface myFunction<T> {
    T test(T t1, T t2);
}

public class Main {
    public static String appendStr(String s) {
        s += "bbb";
        return s;
    }

    public static StringBuilder appendStb(StringBuilder s) {
        s.append("bbb");
        return s;
    }

    public static void main(String[] args) {
        // write your code here
        /*String[] a = change(new String[]{"aa", "bb", "cc", "dd", "ee"});
        for (String value : a
        ) {
            System.out.println(value + "\t");
        }*/

        String a1 = new String("aa");
        String a2 = Main.appendStr(a1);
        System.out.println(a1 + "\t" + a2);
        StringBuilder sb1 = new StringBuilder("aa");
        StringBuilder sb2 = Main.appendStb(sb1);
        Main.appendStb(sb2);
        System.out.println(sb1 + "\t" + sb2);


        /*int[] temp = new int[6];
        int now = (int) (29 * Math.random() + 1);
        boolean type = false;
        int index = 0;
        while (index < 6) {
            for (int i = 0; i < temp.length; i++) {

                if (temp[i] == now) {
                    type = true;
                }

            }
            if (!type) {
                temp[index] = now;
                index++;
            }
            now = (int) (29 * Math.random() + 1);
        }
       *//* for (int i : temp) {
            System.out.println(i);
        }*//*
       int[][] a=number(3);
        for(int i=0;i<a.length;i++)
            for(int j=0;j<a[i].length;j++)
        System.out.println(a[i][j]);*/

    }

    static int[][] number(int row) {
        int col = row;
        int[][] target = new int[row][col];
        target[0][0] = 1;
        int dir = 1;
        for (int i = 0; i < target.length - 1; i++) {
            if (dir == 1) {
                for (int j = i; j < target.length - i; j++) {
                    target[i][j + 1] = target[i][j] + 1;
                }
                dir = 2;
            }//右
            if (dir == 2) {
                for (int j = i + 1; j < target[i].length - i + 1; j++) {
                    target[j][target[i].length - i - 1] = target[j - 1][target[i].length - i - 1] + 1;
                }
                dir = 1;
            }//下
           /* if(dir==3){ for(int j=i+1;j<target.length;j++){target[target.length-i-1][j]=target[target.length-i-1][j-1]-1;}dir=1;}//左
           if(dir==4){ for(int j=0;j<target[i].length-2;j++){target[i][j-1]=target[i][j]+1;}dir=1;}//上*/
        }

        return target;
    }

    static String[] change(String[] a) {
        String[] b = new String[a.length];
        for (int i = 0; i < a.length; i++) {
            b[a.length - 1 - i] = a[i];
        }
        return b;
    }

    @Test
    public void s() {
        Consumer<String> con = System.out::println;
        con.accept("我是消费形");//消费型
        Supplier<Integer> sup = () -> (int) (Math.random() * 10);
        System.out.println(sup.get());//供给型
        Function<Integer, String> fun = (x) -> {
            String str = "zxcvbnmlkjhgfdsaqwertyuiopQWERTYUIOPASDFGHJKLZXCVBNM1234567890";
            //由Random生成随机数
            Random random = new Random();
            StringBuffer sb = new StringBuffer();
            //长度为几就循环几次
            for (int i = 0; i < x; i++) {
                //产生0-61的数字
                int number = random.nextInt(62);
                //将产生的数字通过length次承载到sb中
                sb.append(str.charAt(number));
            }
            //将承载的字符转换成字符串
            return sb.toString();
        };
        System.out.println(fun.apply(4));//函数型
        Predicate<Integer> p = (x) -> (x > 0) ? true : false;
        System.out.println(p.test(10));
        test1("200", (x) -> System.out.println("我今天花了" + x + "元"));

    }

    @Test
    public void test() {
        Comparator<Integer> c = Integer::compare;
        System.out.println(c.compare(3, 2));
        test1("10", System.out::println);
        Stream.generate(() -> Math.random()).forEach(System.out::println);
    }

    void test1(String x, Consumer<String> c) {
        c.accept(x);
    }

}
