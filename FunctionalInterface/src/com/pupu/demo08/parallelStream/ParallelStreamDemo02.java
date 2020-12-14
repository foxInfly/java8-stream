package com.pupu.demo08.parallelStream;

import java.util.Arrays;
import java.util.List;

/**
 * @author lp
 * @since 2020-12-14 16:14:12
 */
public class ParallelStreamDemo02 {

    public static void main(String[] args) {
        Thread thread1 = new Thread(ParallelStreamDemo02::streamTest);

        Thread thread2 = new Thread(ParallelStreamDemo02::streamTest2);
        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //输出：3 4 2 6 7 9 8 1 5

    }

    public static void streamTest(){
        try {
            List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
            numbers.parallelStream().forEach(num->{
                System.out.println("第1次请求并发"+Thread.currentThread().getName()+ ">>" + num);
            });
            try {
                Thread.sleep(5000L);
            }catch (Exception e){
                e.printStackTrace();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void streamTest2(){
        try {
            List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
            numbers.parallelStream().forEach(num->{
                System.out.println("第2次请求并发"+Thread.currentThread().getName()+ ">>" + num);
            });
            try {
                Thread.sleep(5000L);
            }catch (Exception e){
                e.printStackTrace();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
