package com.pupu.demo01.Stream;

import java.io.Serializable;
import java.util.ArrayList;
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
        ArrayList<String> list = new ArrayList<>();
        list.add("张无忌");
        list.add("周芷若");
        list.add("赵敏");
        list.add("张强");
        list.add("张三丰");
//        stream.map(s -> Integer.parseInt(s)).skip(2).forEach(s-> System.out.println(s));
        List<Integer> list0 = stream.map(s -> Integer.parseInt(s)).skip(2).collect(Collectors.toList());
        System.out.println(list0);

        System.out.println(list.stream().filter(a->a.length()==3).collect(Collectors.toList()));
    }
}
