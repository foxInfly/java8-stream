package com.pupu.arithmetic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 *
 *  给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 *  你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 *
 * @author lipu
 * @since 2020-08-12 18:05:42
 */
public class TwoNumberSum {

    public static void main(String[] args) {

        int[] nums = {100,22,2,3,1,4,5,6,7,89,10,11,12,13,14,15,16,17,18,19,232,22,24,242,322,32,33,42,44,442,522,52,53,552,554,542,262,26,36,26,46,42,227,27,73,72,84,28};
        int[] ints = twoSum1(nums, 128);
        for (int anInt : ints) {
            System.out.print(anInt+":"+nums[anInt]);
            System.out.println();
        }

        int[] ints2 = twoSum2(nums, 128);
        for (int anInt : ints2) {
            System.out.print(anInt+":"+nums[anInt]);
            System.out.println();
        }

        int[] ints3 = twoSum3(nums, 128);
        for (int anInt : ints3) {
            System.out.print(anInt+":"+nums[anInt]);
            System.out.println();
        }
    }


    /**
     * 方案1：暴力方法
     * @param nums
     * @param target
     * @return
     */
    private static int[] twoSum1(int[] nums,int target){
        long start = System.currentTimeMillis();
        Integer[] ints = new Integer[2];
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i]+nums[j] == target) {
                    ints[0]=i;
                    ints[1]=j;
                    System.out.println("方案1耗时："+(System.currentTimeMillis()-start));
                    return new int[] { i, j};
                }
            }
        }

        throw new IllegalArgumentException("No two sum solution");
    }


    /**
     * 方案2：两遍哈希表
     * @param nums
     * @param target
     * @return
     */
    private static int[] twoSum2(int[] nums,Integer target){
        long start = System.currentTimeMillis();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            //key是值，value是下标
            map.put(nums[i],i);
        }
        System.out.println(map);
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            //不能重复
            if (map.containsKey(complement) && map.get(complement) != i) {
                System.out.println("方案2耗时："+(System.currentTimeMillis()-start));
                return new int[] { i, map.get(complement) };
            }

        }

        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * 方案3：一遍哈希表
     * @param nums
     * @param target
     * @return
     */
    private static int[] twoSum3(int[] nums,Integer target){
        long start = System.currentTimeMillis();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            //另一个值
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                System.out.println("方案3耗时："+(System.currentTimeMillis()-start));
                return new int[] { map.get(complement), i };
            }
            ////key是值，value是下标
            map.put(nums[i], i);
        }


        throw new IllegalArgumentException("No two sum solution");
    }
}
