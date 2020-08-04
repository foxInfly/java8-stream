package com.pupu.demo07.Function;

import java.util.function.Function;

/**
 * @author : lipu
 * @since : 2020-08-05 06:49
 */
public class Demo03Test {

    public static void main(String[] args) {
        String str = "赵丽颖,20";
        int ageNum = getAgeNum(str, t -> Integer.valueOf(t.split(",")[1]), t -> t + 100);
        System.out.println(ageNum);
    }

    private static int getAgeNum(String str, Function<String,Integer> function1,Function<Integer , Integer> function2){
        return function1.andThen(function2).apply(str);
    }
}
