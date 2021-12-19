package test;

import org.junit.Test;

/**
 * @Author Administrator
 * @Date 2021/8/22 0:46
 * @Version 1.0
 */
public class TestOver implements testIn{
    @Override
    public void show() {
        System.out.println("这是实现类的show");
    }

    @Override
    public void showT() {
        System.out.println("这是实现类的showT");
    }
    @Test
    public void testIn() {
        testIn ti = new TestOver();
        ti.show();
        System.out.println();
        ti.showT();
        System.out.println();
        testIn.showThis();
        System.out.println();
        testIn.super.showT();
        System.out.println();
        ti.showT();
        System.out.println();
        show();
    }
}
interface testIn{
     void  show();
     static void  showThis(){
         System.out.println("这是接口的showThis");
     }
     default void showT(){
         System.out.println("这是接口的showT");
     }

}
