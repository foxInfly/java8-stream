package com.pupu.demo00.Thread;

import java.util.concurrent.CompletableFuture;

public class Demo04CompletableFuture {

    public static void main(String[] args) throws Exception {
        // 创建异步执行任务:
        CompletableFuture<Double> cf = CompletableFuture.supplyAsync(Demo04CompletableFuture::fetchPrice);
        Thread.sleep(200);
        System.out.println("11111");
        // 如果执行成功:
        cf.thenAccept((result) -> {
            System.out.println("price: " + result);
        });
        // 如果执行异常:
        cf.exceptionally((e) -> {
            e.printStackTrace();
            return null;
        });
        // 主线程不要立刻结束，否则CompletableFuture默认使用的线程池会立刻关闭:
        System.out.println("22222");
        Thread.sleep(2000);

    }

    static Double fetchPrice() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
        double random = Math.random();
        System.out.println("random: "+random);
        if (random < 0.3) {
            throw new RuntimeException("fetch price failed!");
        }
        return 5 + Math.random() * 20;
    }
}
