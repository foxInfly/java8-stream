package com.pupu.demo00.completableFuture;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.*;

/**
 *
 */
public class CompletableFuture01Future {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        //轮询获取结果
        for (int i = 0; i < 5; i++) {
            //定义一个异步任务
            Future<String> future = executor.submit(() -> {
                Thread.sleep(2000);
                return "hello world: " + new SimpleDateFormat("yyyy/MM/dd hh:MM:ss").format(new Date());
            });

            while (true) {
                if (future.isDone()) {
                    System.out.println(future.get());
                    break;
                }
            }

        }
    }


    //无返回值
    public static void runAsync() throws Exception {
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("run end ...");
        });

        future.get();
    }

    //有返回值
    public static void supplyAsync() throws Exception {
        CompletableFuture<Long> future = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("run end ...");
            return System.currentTimeMillis();
        });

        long time = future.get();
        System.out.println("time = " + time);
    }
}
