package com.pupu.demo02.Optional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author lipu
 * @since 2020-08-24 16:43:57
 */
public class OptionalOfNullListDemo1 {
    public static void main(String args[]) {


        ArrayList<String> list = new ArrayList<>();
        list.add("张无忌");
        list.add("周芷若");
        list.add("赵敏");
        list.add("张强");
        list.add("张三丰");

        Optional<List<String>> optionalListStr = Optional.ofNullable(null);

        System.out.println("猜猜我是谁： " + optionalListStr.orElse(new ArrayList<>()));

        optionalListStr = Optional.of(list);
        if (optionalListStr.isPresent()) {
            System.out.println("optionalListStr:" + optionalListStr.get());
        }

        optionalListStr.ifPresent(System.out::println);
        System.out.println("------------------------- ");

        System.out.println("optionalListStr.map:  " + optionalListStr.map(a -> a.stream()
                .filter(e->e.length()==3).filter(e->e.startsWith("周")).collect(Collectors.toList())));

        System.out.println("------------------------- ");

        System.out.println( optionalListStr.filter(a -> a.size() > 4)
                .orElse(null));
    }
}

