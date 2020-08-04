package com.pupu.demo07.Function;

import java.util.function.Function;

/**
 * @author : lipu
 * @since : 2020-08-05 06:42
 */
public class Demo01Function {
    private static void method(String name,Function<String,Integer> function){
        Integer num = function.apply(name);
        System.out.println(num+10);
    }

    public static void main(String[] args) {
        method("10",t->Integer.valueOf(t));
    }
}
