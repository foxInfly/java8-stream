package com.pupu.demo00.completableFuture;


import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 *
 */
public class Demo03Future {

    public static void main(String[] args) throws Exception {
        whenComplete();
        System.out.println(Thread.currentThread().getName()+":执行");
    }


    public static void whenComplete() throws Exception {
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
            }
            int randomInt = new Random().nextInt();
            int random =randomInt % 2;
            if(random>=0) {
                int i = 12/0;
            }
            System.out.println("run end ...");
        });

        future.whenComplete(new BiConsumer<Void, Throwable>() {
            @Override
            public void accept(Void t, Throwable action) {
                System.out.println("whenComplete 执行完成！");
            }

        });
        future.exceptionally(new Function<Throwable, Void>() {
            @Override
            public Void apply(Throwable t) {
                System.out.println("exceptionally 执行失败！"+t.getMessage());
                return null;
            }
        });

        TimeUnit.SECONDS.sleep(2);
    }
}
