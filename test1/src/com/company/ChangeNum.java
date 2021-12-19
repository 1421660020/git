package com.company;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;


public class ChangeNum {
    public int twoToTen(String two) throws NumberFormatException {
        String ten = two;
        int result = 0;
        for (int i = 0; i < ten.length(); i++) {
            //    int j = ;
            // result += (new Double(Math.pow(2, i)).intValue() * Integer.parseInt(String.valueOf(ten.charAt(j))));
            //   result += (int) Math.pow(2, i) * Integer.parseInt(String.valueOf(ten.charAt(j)));
            result += (1 << i) * Integer.parseInt(String.valueOf(ten.charAt(ten.length() - i - 1)));
        }
        return result;


    }

    public void yangHuiTri(int row) {
        System.out.println("----------------------");
        int[][] yangHui = new int[row][];
        // yangHui[0] = new int[]{1};
        //  System.out.println(yangHui[0][0]);
        for (int i = 0; i < row; i++) {
            yangHui[i] = new int[i + 1];
            for (int j = 0; j < yangHui[i].length; j++) {
                if (j == 0 || j == i) yangHui[i][j] = 1;
                else yangHui[i][j] = yangHui[i - 1][j - 1] + yangHui[i - 1][j];
                System.out.print(yangHui[i][j] + "\t");
            }
            System.out.println();
        }

        //  System.out.println(Arrays.stream(yangHui));
    }

    public void randomArray(int length) {
        int[] randomArray = new int[length];
        int temp;
        ArrayList<Integer> compareArray = new ArrayList<>();

        while (compareArray.size() < length) {
            temp = (int) (Math.random() * 29 + 1.0);
            //  System.out.println(temp);
            if (!compareArray.contains(temp)) {
                compareArray.add(temp);
            }
        }
        for (Integer i = 0; i < compareArray.size(); i++) {
            randomArray[i] = compareArray.get(i);
            System.out.println(randomArray[i] + "\t");
        }
    }

    public String grade(double mark) {
        return mark >= 0 ? mark < 60 ? "不及格" : (mark < 80 ? "及格" : (mark < 90 ? "良" : (mark <= 100 ? "优" : "你给的分数太大了"))) : "你给的分数太小了";

    }

    public double math(double d1, double d2) {
        return d1 > 10.0 && d2 < 20.0 ? d1 + d2 : d1 * d2;
    }

    public int findMax(int i1, int i2, int i3) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileReader("C:\\Users\\Administrator\\Desktop\\1.txt"));
        String s = "";
        while (scanner.hasNextLine()) {
            s += scanner.nextLine() + "\n";

        }
        System.out.println(s);
        scanner.close();
        return i1 > i2 ? i1 > i3 ? i1 : i3 : i2 > i3 ? i2 : i3;
    }

    public static void main(String[] args) {

        String[] s = {"1", "2", "3"};
        System.out.println(args);
     /*   int[] a={1,2,3};
        System.out.println(a);*/
      /*  for (int i = 0; i < 10; i++) {
            if(i == 2) continue;
            else System.out.println(i);
        }*/
        ChangeNum c1 = new ChangeNum();
        // System.out.println(c1);
      /*  try {
            System.out.println(c1.findMax(3, 6, 3));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }*/
        System.out.println(c1.twoToTen("01111"));

        c1.split(1234567, new int[]{7, 2, 3});
        System.out.println(c1.math(10.1, 1));
        c1.yangHuiTri(10);

        c1.randomArray(29);
    }
/*byte b= 10;
        System.out.println(Integer.toBinaryString(b));*/
       /* byte b = 127;
        System.out.println(++b);*/
        /*int i = 0;
        boolean b = ++i == 0 && i++ == 0 ? true : false;
        System.out.println(i + "\t"+b);*/
       /* int a = 10, b = 20;
//        a=a+b;
//        b=a-b;
//        a=a-b;
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println(a + "\t" + b);*/
//  System.out.println(new ChangeNum().grade(101));

    public void split(int originNum, int[] index) {
        String s = originNum + "";
        String result = s.charAt(s.length() - index[0]) + "";
        int i = 1;
        while (i < index.length) {
            result += "\t" + s.charAt(s.length() - index[i]);
            i++;
        }
        System.out.println(result);
    }
    // System.out.println(s.charAt(s.length() - 3));


}

