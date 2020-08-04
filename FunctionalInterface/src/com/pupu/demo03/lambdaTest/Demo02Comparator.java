package com.pupu.demo03.lambdaTest;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author : lipu
 * @since : 2020-08-04 21:47
 */
public class Demo02Comparator {

    private static Comparator<String> newComparator(){
        return (a,b)->b.length() - a.length();//谁在前，为true则在前面
    }


    public static void main(String[] args) {
        String[] arr = {"abc","ab","abcd","a"};
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr,newComparator());
        System.out.println(Arrays.toString(arr));
    }
}
