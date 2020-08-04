package com.pupu.demo04.Supplier;

import java.util.function.Supplier;

/**
 * @author : lipu
 * @since : 2020-08-04 21:58
 */
public class Demo01Supplier {

    private static String getString(Supplier<String> supplier){
        return supplier.get();
    }

    public static void main(String[] args) {
        String msg1 = "Hello ";
        String msg2 = "World";

        System.out.println(getString(()->msg1+msg2));
    }
}
