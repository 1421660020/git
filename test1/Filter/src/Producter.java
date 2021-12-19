/**
 * @Author Administrator
 * @Date 2021/12/9 6:24
 * @Version 1.0
 */
public class Producter extends Thread {
    String threadName = "";

    public void setThreadName(String name) {
        this.threadName = name;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (Thread.class) {
                Thread.class.notifyAll();
                if (MyThread.i < 20) {
                    MyThread.i++;
                    System.out.println("生产者" + threadName + "正在生成第" + MyThread.i + "个商品");
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
