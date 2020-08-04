package com.pupu.demo04.Supplier;

import java.util.function.Supplier;

/**
 * @author : lipu
 * @since : 2020-08-04 22:02
 */
public class Demo02Test {

    private static int getMax(Supplier<Integer> supplier){
        return supplier.get();
    }

    public static void main(String[] args) {
        int[] arr = {2,234,45,6,7,88,954,34,5,20};

        int maxNum = getMax(() -> {
            int max = arr[0];
            for (int i : arr) {
                if (i > max) {
                    max = i;
                }
            }
            return max;
        });
        System.out.println("最大值为："+maxNum);
    }
}
