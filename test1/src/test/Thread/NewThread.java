package test.Thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author Administrator
 * @Date 2021/8/25 21:03
 * @Version 1.0
 */
public class NewThread implements Runnable {
    private int Ticket = 300;
    private long startTime = 0;
    private long endTime = 0;
    Lock lock = new ReentrantLock();

    @Override
    public void run() {

        while (true) {
           // lock.lock();
             synchronized (NewThread.class) {
            if (Ticket == 100) startTime = System.currentTimeMillis();
            if (Ticket > 0) {

                System.out.println(Ticket + Thread.currentThread().getName());
                Ticket--;
                //
            } else {
                endTime = System.currentTimeMillis();
                System.out.println(endTime - startTime);
                break;
            }
            //lock.unlock();
        }
         }
    }


    public static void main(String[] args) {
        Thread.currentThread().setName("主线程");
        NewThread nt = new NewThread();

        Thread s1 = new Thread(nt, "Thread_1");
        Thread s2 = new Thread(nt, "Thread_2");
        Thread s3 = new Thread(nt, "Thread_3");
        s1.start();
        s2.start();
        s3.start();


    }
}


