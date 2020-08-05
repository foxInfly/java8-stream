package com.pupu.demo01.Stream;

import java.util.stream.Stream;

/**
 * @author : lipu
 * @since : 2020-08-05 22:37
 */
public class Demo04Stream_forEach {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("张三", "李四", "王五", "赵六", "田七");
//        stream.forEach(name-> System.out.println(name));
        stream.filter(name->name.contains("张")).forEach(name-> System.out.println(name));
    }
}
