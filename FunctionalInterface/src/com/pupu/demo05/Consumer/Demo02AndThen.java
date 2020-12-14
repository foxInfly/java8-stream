package com.pupu.demo05.Consumer;

import java.util.function.Consumer;

/**
 * 谁写前面谁先消费,只是消费，不改变原来的值
 *
 * @author : lipu
 * @since : 2020-08-04 22:30
 */
public class Demo02AndThen {

    public static void method(String s, Consumer<String> consumer1, Consumer<String> consumer2) {
//        consumer1.accept(s);
//        consumer2.accept(s);
        consumer1.andThen(consumer2).accept(s);
    }

    public static void main(String[] args) {
        method("Hello", (t) -> {
            t = t.toUpperCase();
            System.out.println(t);
        }, (t) -> {
            System.out.println(t);
            System.out.println(t + "123");
        });
    }

}
