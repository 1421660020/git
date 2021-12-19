package test.Thread;

import java.time.Instant;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author Administrator
 * @Date 2021/8/26 5:08
 * @Version 1.0
 */
public class ThreadPool {
    public static void main(String[] args) {
        ExecutorService s= Executors.newFixedThreadPool(10);
        ThreadPoolExecutor tp=(ThreadPoolExecutor)s;
        Instant i=Instant.parse("2020-1-1 12:00:00");
        System.out.println(i);

    }
}
