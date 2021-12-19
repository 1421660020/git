package test.Thread;

import java.util.ArrayList;

import java.util.List;

/**
 * @Author Administrator
 * @Date 2021/8/26 5:26
 * @Version 1.0
 */
public class ThreadLocalT {
    static volatile ThreadLocal<String> t = new ThreadLocal<>();
    static volatile boolean isChange = false;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {

        Thread t2 = new Thread(() -> {

            //  synchronized (Thread.class) {
                 /*   try {
                        Thread.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }*/
            //   while (true) {

            //   if (isChange) {
            while (true){
            if (isChange) {System.out.println("已检测到...");break;}}
            //  Thread.class.notify();
            //   }
            //   break;


        });
        t2.start();

        new Thread(() -> {
            //  synchronized (Thread.class) {
            isChange = false;
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
                if (i == 5) {
                    // isChange = true;
                     /*   try {
                            Thread.class.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }*/
                    isChange = true;


                 /*   try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }*/
                    try {
                        t2.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
                //        Thread.class.notify();
                //       System.out.println(t2.isAlive());
                list.add(i);

                //  }
            }
        }).start();


/*
        new Thread(() -> {
            t.set("t1");
            print("thread1");
        }).start();
        new Thread(() -> {
            t.set("t2");
            print("thread2");
        }).start();
        System.out.println(t.get());*/
    }

    static void print(String s) {
        System.out.println(s + ":" + t.get() + Thread.currentThread().getName());
    }
}
