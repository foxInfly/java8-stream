package com.pupu.demo00.Thread;

import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Demo02ScheduleExecutor {

    public static void main(String[] args) {
        //定期反复执行的线程池
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(4);
        // 1秒后执行一次性任务:
        ses.schedule(() -> System.out.println(Thread.currentThread().getName()+":  " +System.currentTimeMillis()), 1, TimeUnit.SECONDS);

        // 2秒后开始执行定时任务，每过3秒执行:
//        ses.scheduleAtFixedRate(new Task("fixed-rate"), 2, 3, TimeUnit.SECONDS);

        // 2秒后开始执行定时任务，每次执行完后以3秒为间隔执行:
//        ses.scheduleWithFixedDelay(new Task("fixed-delay"), 2, 3, TimeUnit.SECONDS);
        System.out.println(Thread.currentThread().getName()+":  " +"main");
    }


}
