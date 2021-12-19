import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author Administrator
 * @Date 2021/12/9 2:46
 * @Version 1.0
 */
public class MyThread {
    private static Lock lock = new ReentrantLock();
    private static int count = 0;
    public  static int i = 1;


    //    public static void main(String[] args) {
//
//        Thread myThread1 = new Thread(() -> {
//            while (true) {
//                lock.lock();
//                if (count < 100) {
//
//                    if (count % 4 == 0) {
//                        count++;
//                        System.out.println(Thread.currentThread().getName() + ": " + count);
//                    }
//                    lock.unlock();
//
//                } else {
//                    break;
//                }
//            }
//        });
//        Thread myThread2 = new Thread(() -> {
//            while (true) {
//                lock.lock();
//                if (count < 100) {
//
//                    if (count % 4 == 1) {
//                        count++;
//                        System.out.println(Thread.currentThread().getName() + ": " + count);
//                    }
//                    lock.unlock();
//
//                } else {
//                    break;
//                }
//            }
//        });
//        Thread myThread3 = new Thread(() -> {
//            while (true) {
//                lock.lock();
//                if (count < 100) {
//
//                    if (count % 4 == 2) {
//                        count++;
//                        System.out.println(Thread.currentThread().getName() + ": " + count);
//                    }
//                    lock.unlock();
//
//                } else {
//                    break;
//                }
//            }
//        });
//        Thread myThread4 = new Thread(() -> {
//            while (true) {
//                lock.lock();
//                if (count < 100) {
//
//                    if (count % 4 == 3) {
//                        count++;
//                        System.out.println(Thread.currentThread().getName() + ": " + count);
//                    }
//                    lock.unlock();
//
//                } else {
//                    break;
//                }
//            }
//        });
//        myThread4.start();
//        myThread3.start();
//        myThread2.start();
//        myThread1.start();
//
//
//
//
//
//    }
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                try {
                    while (true) {
                        synchronized (Thread.class) {
                            Thread.class.notifyAll();
                            Thread.class.wait();
                            if (i == 1) {
                                System.out.println(1);
                                i = 2;
                            }
                        }
                    }
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            public void run() {
                try {
                    while (true) {
                        synchronized (Thread.class) {
                            Thread.class.notifyAll();
                            Thread.class.wait();
                            if (i == 2) {
                                System.out.println(2);
                                i = 3;
                            }
                        }
                    }
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });

        Thread t3 = new Thread(new Runnable() {
            public void run() {
                try {
                    while (true) {
                        synchronized (Thread.class) {
                            Thread.class.notifyAll();
                            Thread.class.wait();
                            if (i == 3) {
                                System.out.println(3);
                                i = 4;
                            }
                        }
                    }
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });

        Thread t4 = new Thread(new Runnable() {
            public void run() {
                try {
                    while (true) {
                        synchronized (Thread.class) {
                            Thread.class.notifyAll();
                            Thread.class.wait();
                            if (i == 4) {
                                System.out.println(4);
                                i = 1;
                            }
                        }
                    }
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}