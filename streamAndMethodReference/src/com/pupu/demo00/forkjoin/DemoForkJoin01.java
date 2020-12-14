package com.pupu.demo00.forkjoin;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

public class DemoForkJoin01 {

    public static void main(String[] args) {
        // 创建2000个随机数组成的数组:
        long[] array = new long[2004];
        long expectedSum = 0;
        for (int i = 0; i < array.length; i++) {
            array[i] = random();
            expectedSum += array[i];
        }
        System.out.println("Expected sum: " + expectedSum);
        // fork/join:
        ForkJoinTask<Long> task = new SumTask(array, 0, array.length);
        long startTime = System.currentTimeMillis();
        Long result = ForkJoinPool.commonPool().invoke(task);
        long endTime = System.currentTimeMillis();
        System.out.println("Fork/join sum: " + result + " in " + (endTime - startTime) + " ms.");
        long expectedSum1 = 0;
        long startTime1 = System.currentTimeMillis();
        for (int i = 0; i < array.length; i++) {
            expectedSum1 += array[i];
        }
        long endTime1 = System.currentTimeMillis();
        System.out.println("for sum: " + expectedSum1 + " in " + (endTime1- startTime1) + " ms.");
    }

    private static Random random = new Random(0);

    //生成10000内的随机数
    private static long random() {
        return random.nextInt(10000);
    }
}
