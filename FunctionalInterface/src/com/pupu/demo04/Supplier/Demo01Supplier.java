package com.pupu.demo04.Supplier;

import java.util.function.Supplier;

/**
 * Supplier供应者，根据给定的入参生成指定类型的返回值
 *
 * @author : lipu
 * @since : 2020-08-04 21:58
 */
public class Demo01Supplier {

    private static String getString(Supplier<String> supplier) {
        String s = supplier.get();
        System.out.println(s);
        return supplier.get();
    }

    public static void main(String[] args) {
        String msg1 = "Hello ";
        String msg2 = "World";

        System.out.println(getString(() -> msg1 + msg2));
    }
}
