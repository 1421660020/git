package test.Thread;


import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author Administrator
 * @Date 2021/8/25 23:50
 * @Version 1.0
 */
public class Product {
    private volatile int product = 0;
    Object obj=new Object();
    public static void main(String[] args) {
        Product product = new Product();
        Producer producer = new Producer(product);
        Consumer consumer = new Consumer(product);
        Consumer consumer1 = new Consumer(product);
        producer.setName("生产者1");
        consumer.setName("消费者1");
        consumer1.setName("消费者2");
        producer.start();
        consumer.start();
        consumer1.start();
    }

    public  void increase() {
        ReentrantLock r=new ReentrantLock();
        synchronized (obj){
            r.lock();
        obj.notifyAll();
        if (product < 20) {
            product++;
            System.out.println(Thread.currentThread().getName()+"\t现在正在生产第" + product + "个产品");
        } else {
            try {
                obj.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }}
    }

    public  void decrease() {
        synchronized(obj){
       obj. notifyAll();
        if (product > 0) {
            System.out.println(Thread.currentThread().getName()+"\t现在正在消费第" + product + "个产品");
            product--;
        } else {
            try {
              obj.  wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }}
    }

}

class Producer extends Thread {
    private Product product;

    Producer(Product product) {
        System.out.println("生产者开始生产...");
        this.product = product;
    }

    @Override
    public void run() {


        while (true) {
            product.increase();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}


class Consumer extends Thread {
    private Product product;

    Consumer(Product product) {
        System.out.println("消费者开始消费...");
        this.product = product;
    }

    @Override
    public void run() {
        super.run();
        while (true) {
            try {
                product.decrease();
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}