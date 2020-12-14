package com.pupu.demo00.completableFuture;


import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 *
 */
public class CompletableFuture03Future {

    public static void main(String[] args) throws Exception {
        whenCompleteAs();
        System.out.println(Thread.currentThread().getName()+":执行结束");
    }


    public static void whenComplete() throws Exception {
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            int randomInt = new Random().nextInt();
            int random =randomInt % 2;
            System.out.println(random);
            if(random>=0) {
                int i = 12/0;
            }
            System.out.println("run end ...");
        });

        future.whenComplete((t, action) -> {
            System.out.println("whenComplete 执行完成！");
            System.out.println( action.getMessage());
        });

        future.exceptionally(t -> {
            System.out.println("exceptionally 执行失败！"+t.getMessage());
            return null;
        });

        TimeUnit.SECONDS.sleep(2);
    }

    public static void whenCompleteAs() throws Exception {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            int random = new Random().nextInt();
            System.out.println(random);
            if(random>=0) {
                int i = 12/0;
                return i;
            }
            System.out.println("run end ...");
            return random;
        });

        //t是返回结果，action是异常信息
        future.whenComplete((t, action) -> {
            System.out.println("whenComplete 执行完成！");
            System.out.println("www:"+t.toString());
        });

        future.exceptionally(t -> {
            System.out.println("exceptionally 执行失败！"+t.getMessage());
            return null;
        });

        TimeUnit.SECONDS.sleep(3);
    }
}
