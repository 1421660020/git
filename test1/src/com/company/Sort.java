package com.company;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.stream.Stream;

/**
 * @Author Administrator
 * @Date 2021/8/1 10:06
 * @Version 1.0
 */

public class Sort {
    @Test
    public void quickSort() {
        int[] a = {3, 3, 5, 7, 8, 9, 24, 1, 2};
        int[] low = {3, 3, 5, 7, 8, 9, 24, 1, 2};
        int lowCount = 0;
        int[] high = {3, 3, 5, 7, 8, 9, 24, 1, 2};
        int highCount = 0;
        for (int i = 0; i < a.length; i++) {

            for (int j = 0; j < low.length; j++) {//low
                if (a[i] > low[j]) {
                    low[lowCount] = low[j-1];
                    lowCount++;
                }
            }
            int temp = a[i];
            a[i] = a[lowCount];
            a[lowCount] = temp;

     /*       for (int j = a.length - 1; j > 0; j--) {//high
                if (a[j] > a[i]) {
                    high[a.length - 1 - highCount] = a[j];
                    highCount++;
                }
            }*/
        }
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }


    }


    @Test
    public void sortBubble() {//选择排序
        System.out.println("选择排序");
        int[] a = {1, 3, 5, 7, 8, 9, 24, 1, 2, -10, -9, 1};
        int min;
        int temp;
        for (int i = 0; i < a.length - 1; i++) {
            min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[min] > a[j]) {
                    min = j;
                }
            }
            temp = a[min];
            a[min] = a[i];
            a[i] = temp;
        }
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    @Test
    public void sortXuanze() {//冒泡排序
        System.out.println("冒泡排序");
        int[] a = {1, 3, 5, 7, 8, 9, 24, 1, 2};
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j + 1] < a[j]) {
                    int temp = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = temp;
                }
            }
        }
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    @Test
    public void sortCharu() {
        System.out.println("插入排序");
        int[] a = {3, 3, 5, 7, 8, 9, 24, 1, 2};
        for (int i = 1; i < a.length; i++) {
            int temp = a[i];
            for (int j = i - 1; j >= 0; j--) {
                if (a[j] < temp) break; //找到可以放的位置即跳出
                a[j + 1] = a[j];
                a[j] = temp;
            }

        }

        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    public static void main(String[] args) {

    }
}
