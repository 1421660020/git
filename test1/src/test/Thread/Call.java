package test.Thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author Administrator
 * @Date 2021/8/26 4:36
 * @Version 1.0
 */
public class Call implements Callable<String> {
    private volatile static boolean isTrue = false;

    @Override
    public String call() {
        int i = 0;
        while (i < 40) {
            i++;
            if (i % 2 == 0) {

                isTrue = true;
            } else {
                isTrue = false;
            }
        }
        return "现在isTrue的值为: " + isTrue;
    }

    public static void main(String[] args) {
        Callable c=new Call();
        FutureTask fs=new FutureTask(c);
        new Thread(fs).start();
        try {
            System.out.println(fs.get()+"任务是否正常完成"+!fs.isCancelled());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
