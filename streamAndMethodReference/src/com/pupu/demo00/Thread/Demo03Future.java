package com.pupu.demo00.Thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


/**
 * get()：获取结果（可能会等待）
 * get(long timeout, TimeUnit unit)：获取结果，但只等待指定的时间；
 * cancel(boolean mayInterruptIfRunning)：取消当前任务；
 * isDone()：判断任务是否已完成。
 */
public class Demo03Future {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 创建固定大小的线程池:
        ExecutorService executor = Executors.newFixedThreadPool(3);
        Future<String> future = executor.submit(new TaskCallable("猜我是不是Callable"));
        String s = future.get();//会阻塞，直到返回结果
        System.out.println(s);
    }
}
