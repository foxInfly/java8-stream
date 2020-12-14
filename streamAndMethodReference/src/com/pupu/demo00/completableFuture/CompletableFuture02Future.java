package com.pupu.demo00.completableFuture;


import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.*;

/**
 *
 */
public class CompletableFuture02Future {

    public static void main(String[] args) throws Exception {
        runAsync();
        supplyAsync();
        InputStream in = System.in;//防止后一个线程结束了，第一个还没结束
    }


    //无返回值
    public static void runAsync() {
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
                System.out.println("after:"+ new SimpleDateFormat("yyyy/MM/dd hh:MM:ss").format(new Date()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("runAsyn end ..."+ new SimpleDateFormat("yyyy/MM/dd hh:MM:ss").format(new Date()));
        });

        System.out.println("runAsync arithmetic ..." + new SimpleDateFormat("yyyy/MM/dd hh:MM:ss").format(new Date()));
    }

    //有返回值,拿到返回值，会继续走，结束程序
    public static void supplyAsync() throws Exception {
        CompletableFuture<Long> future = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println(Thread.currentThread().getName()+"===============");
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"------------------");
            System.out.println("supplyAsync() run end ..." + new SimpleDateFormat("yyyy/MM/dd hh:MM:ss").format(new Date()));
            return System.currentTimeMillis();
        });

        long time = future.get();
        System.out.println(Thread.currentThread().getName()+":time = " + time);
    }
}
