package com.pupu.demo15.lambda;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * 秋一个int数组中的最小值
 * @author lp
 * @since 2021-04-23 15:48:54
 */
public class Lp01_MinDemo {

    public static void main(String[] args) {
        int[] nums =createNums(100*10000);
//        int[] nums =createNums(10000*10000);
//        int[] nums =createNums(10);
        /*for (int i:nums) {
            System.out.print(i+",");
        }*/
        System.out.println();

        int min = Integer.MAX_VALUE;

        //==========1.=========；当10000*10000时，耗时46
        long begin1 = System.currentTimeMillis();

        for (int i: nums) {
            if (i < min) {
                min = i;
            }
        }
        long end1 = System.currentTimeMillis();

        System.out.println("min1:"+min+"；耗时："+(end1-begin1));

        //==========2.=========；当10000*10000时，耗时102
        long begin2 = System.currentTimeMillis();
        //jdk8

        int min2 = IntStream.of(nums).min().getAsInt();
        long end2 = System.currentTimeMillis();
        System.out.println("min2:"+min2+"；耗时："+(end2-begin2));

        //==========3.=========
        //jdk8,parallel():并行，就是多线程；当10000*10000时，耗时31
        long begin3 = System.currentTimeMillis();
        int min3 = IntStream.of(nums).parallel().min().getAsInt();
        long end3 = System.currentTimeMillis();
        System.out.println("min3:"+min3+"；耗时："+(end3-begin3));
    }


    public static int[] createNums(int count){
        int[] nums = new int[count];

        Random random = new Random();
        for (int i = 0; i < count; i++) {
            nums[i] = (int)(1+Math.random()*(count-1+1));
        }

        return nums;
    }
}
