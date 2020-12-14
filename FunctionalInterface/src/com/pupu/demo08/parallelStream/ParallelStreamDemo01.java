package com.pupu.demo08.parallelStream;

import java.util.Arrays;
import java.util.List;

/**
 * @author lp
 * @since 2020-12-14 16:14:12
 */
public class ParallelStreamDemo01 {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        numbers.parallelStream().forEach(num -> System.out.println(Thread.currentThread().getName() + ">>" + num));


        //输出：3 4 2 6 7 9 8 1 5

    }
}
