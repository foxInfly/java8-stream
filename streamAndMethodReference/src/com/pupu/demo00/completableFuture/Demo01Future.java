package com.pupu.demo00.completableFuture;


import java.util.concurrent.*;

/**
 *
 */
public class Demo01Future {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        //定义一个异步任务
        Future<String> future = executor.submit(() -> {
            Thread.sleep(2000);
            return "hello world";
        });
        //轮询获取结果
        while(true){
            if (future.isDone()) {
                System.out.println(future.get());
                break;
            }
        }
    }


    //无返回值
    public static void runAsync() throws Exception {
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
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
            }
            System.out.println("run end ...");
            return System.currentTimeMillis();
        });

        long time = future.get();
        System.out.println("time = "+time);
    }
}
