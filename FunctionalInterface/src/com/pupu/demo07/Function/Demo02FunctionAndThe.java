package com.pupu.demo07.Function;

import java.util.function.Function;

/**
 * @author : lipu
 * @since : 2020-08-05 06:46
 */
public class Demo02FunctionAndThe {

    private static void method(String name, Function<String,Integer> function1,Function<Integer,Integer> function2){
        Integer num = function1.andThen(function2).apply(name);
        System.out.println(num+10);
    }

    public static void main(String[] args) {
        method("10", Integer::valueOf, t->t-2);
    }
}
