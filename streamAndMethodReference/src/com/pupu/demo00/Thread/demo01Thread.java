package com.pupu.demo00.Thread;




import javafx.concurrent.Task;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**Executors:
 *  FixedThreadPool：线程数固定的线程池；
 *  CachedThreadPool：线程数根据任务动态调整的线程池；
 *  SingleThreadExecutor：仅单线程执行的线程池。
 */
public class demo01Thread {
    public static void main(String[] args) {

        //定期反复执行的线程池
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(4);
        // 1秒后执行一次性任务:
        ses.schedule(()-> System.out.println(System.currentTimeMillis()), 1, TimeUnit.SECONDS);


        // 创建固定大小的线程池:
        ExecutorService executor = Executors.newFixedThreadPool(3);
        executor.submit(()-> System.out.println("thread run..."));
        Thread t = new Thread() {
            @Override
            public void run() {
                System.out.println("thread run...");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {}
                System.out.println("thread end.");
            }
        };
        t.start();
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {}
        System.out.println("main end...");
    }
}
