package com.pupu.demo06.Predicate;

import java.util.function.Predicate;

/**
 * @author : lipu
 * @since : 2020-08-04 22:55
 */
public class Demo04PredicateNegate {

    private static void method(String name, Predicate<String> predicate1, Predicate<String> predicate2){
        boolean b = predicate1.negate().test(name);
        System.out.println("字符串是否不包含H："+b);
    }

    public static void main(String[] args) {
        method("HelloWorld",t->t.contains("H"),t->t.contains("M"));
    }
}
