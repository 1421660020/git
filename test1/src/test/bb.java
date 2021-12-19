package test;

import org.junit.Test;

import java.util.Objects;

/**
 * @Author Administrator
 * @Date 2021/8/10 5:57
 * @Version 1.0
 */
public class bb  {
    int c = 10;

    {
        c = 20;

       c= Integer.parseInt(Integer.toBinaryString(c));
    }

    private static final int g = 10111111;

    public int getC() {
        Sinleton.instance();
        return c;

    }

    public void show() {
        System.out.println(c);
    }

    @Test
    public void show2() {

        System.out.println(c);
            Sinleton s1 = Sinleton.instance();
            Sinleton s2 = Sinleton.instance();
            System.out.println(s1 == s2);



    }

}

class cc extends bb {
    int c = 20;
    int d;



    public void show1() {
        System.out.println(d + "" + c);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        cc cc = (cc) o;
        return c == cc.c &&
                d == cc.d;
    }

    @Override
    public int hashCode() {
        return Objects.hash(c, d);
    }

    @Override
    public void show() {

        System.out.println(111);
    }

    @Test
    public static void main(String args[]) {
        bb b=new bb();
        cc c=(cc)b;

      /*
       bb b= new cc();
       new bb().show();*/
   /*         bb b = new bb();
        System.out.println(b);

            if(!(b instanceof cc))
                System.out.println("不能转换");
            else  {cc c=(cc)b; c.show1();}
            // bb s1=new bb();*/

    }

}

