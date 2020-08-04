package com.pupu.demo05.Consumer;

import java.util.function.Consumer;

/**
 * @author : lipu
 * @since : 2020-08-04 22:15
 */
public class Demo01Consumer {

    private static void consumerString(String name,Consumer<String> consumer){
        consumer.accept(name);
    }

    public static void main(String[] args) {
        consumerString("Hello",s-> System.out.println(s.toUpperCase()));
    }
}
