package com.pupu.demo05.Consumer;

import java.util.function.Consumer;

/**
 * @author : lipu
 * @since : 2020-08-04 22:15
 */
public class Demo01Consumer {

    private static void consumerString(Consumer<String> consumer){
        consumer.accept("Hello");
    }

    public static void main(String[] args) {
        consumerString(s-> System.out.println(s.toUpperCase()));
    }
}
