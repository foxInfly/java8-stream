package com.pupu.demo06.Predicate;

import java.util.function.Predicate;

/**Predicate谓语，断言，
 * @author : lipu
 * @since : 2020-08-04 22:48
 */
public class Demo01Predicate {

    private static void method(String name,Predicate<String> predicate){
        boolean b = predicate.test(name);
        System.out.println("字符串的是否超过10："+b);
    }

    public static void main(String[] args) {
        method("aaswedsdw2sss",t->t.length()>10);
    }
}
