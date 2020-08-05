package com.pupu.demo00.Thread;

import java.util.concurrent.Callable;

public class TaskCallable implements Callable<String> {

    private final String name;
    public TaskCallable(String name) {
        this.name = name;
    }


    @Override
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName() +":  " +name+":start    "+System.currentTimeMillis());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        System.out.println(Thread.currentThread().getName()+":  " +name+":end    " +System.currentTimeMillis());
        StringBuffer buffer = new StringBuffer(name).reverse();
        return buffer.toString();
    }
}