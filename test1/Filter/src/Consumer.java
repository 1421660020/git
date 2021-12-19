/**
 * @Author Administrator
 * @Date 2021/12/9 6:24
 * @Version 1.0
 */
public class Consumer extends Thread {
    String threadName = "";

    public void setThreadName(String name) {
        this.threadName = name;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (Thread.class) {
                Thread.class.notifyAll();
                if (MyThread.i > 0) {
                    System.out.println("消费者" + threadName + "正在消费第" + MyThread.i + "个商品");
                    MyThread.i--;
                }
                try {

                    Thread.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


        }
    }
}
