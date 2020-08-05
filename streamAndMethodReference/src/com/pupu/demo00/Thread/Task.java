package com.pupu.demo00.Thread;

import java.util.Date;

public class Task implements Runnable {

    private final String name;
    public Task(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() +":  " +name+":start    "+System.currentTimeMillis());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        System.out.println(Thread.currentThread().getName()+":  " +name+":end    " +System.currentTimeMillis());
    }
}