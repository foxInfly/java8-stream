package com.pupu.demo03.lambdaTest;

/**
 * @author : lipu
 * @since : 2020-08-04 21:43
 */
public class Demo01Runnable {

    private static void startThread(Runnable task){
        new Thread(task).start();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            startThread(() -> System.out.println(Thread.currentThread().getName() + "线程执行"));
        }
    }
}
