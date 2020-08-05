package com.pupu.demo01.Stream;

import java.util.stream.Stream;

/**
 * @author : lipu
 * @since : 2020-08-05 22:49
 */
public class Demo06Stream_concat {
    public static void main(String[] args) {
        Stream<String> a = Stream.of("pupu");
        Stream<String> b = Stream.of("琼");
        Stream.concat(a, b).forEach(c-> System.out.println(c));
    }
}
