package com.pupu.demo01.Stream;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author : lipu
 * @since : 2020-08-05 22:44
 */
public class Demo05Stream_Map {

    public static void main(String[] args) {
        Stream<String> stream = Stream.of("10", "12","2");
//        stream.map(s -> Integer.parseInt(s)).skip(2).forEach(s-> System.out.println(s));
        List<Integer> list = stream.map(s -> Integer.parseInt(s)).skip(2).collect(Collectors.toList());
        System.out.println(list);
    }
}
