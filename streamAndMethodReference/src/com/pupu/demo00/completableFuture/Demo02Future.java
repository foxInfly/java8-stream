package com.pupu.demo00.completableFuture;


import java.util.concurrent.*;

/**
 *
 */
public class Demo02Future {

    public static void main(String[] args) throws Exception {
        runAsync();
        supplyAsync();
        System.out.printf(Thread.currentThread().getName()+":执行");
    }


    //无返回值
    public static void runAsync() throws Exception {
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
            }
            System.out.println(Thread.currentThread().getName()+":runAsync() run end ...");
        });

        future.get();
        System.out.println(Thread.currentThread().getName()+":runAsync() arithmetic ...");
    }

    //有返回值
    public static void supplyAsync() throws Exception {
        CompletableFuture<Long> future = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
            }
            System.out.println(Thread.currentThread().getName()+":supplyAsync() run end ...");
            return System.currentTimeMillis();
        });

        long time = future.get();
        System.out.println(Thread.currentThread().getName()+":time = " + time);
    }
}
