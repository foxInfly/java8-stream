package com.pupu.demo02.Optional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author lipu
 * @since 2020-08-24 16:43:57
 */
public class OptionalOfDemo1 {
    public static void main(String args[]) {


        ArrayList<String> list = new ArrayList<>();
        list.add("张无忌");
        list.add("周芷若");
        list.add("赵敏");
        list.add("张强");
        list.add("张三丰");

        // 此方式不可为null,是null 会报空指针
        Optional<String> optionalStr = Optional.of("Hello Optional.isPresent");
//        Optional<String> optionalNul = Optional.of(null);
        Optional<List<String>> optionalListStr = Optional.of(list);


        System.out.println("optionalStr=" + optionalStr);
        System.out.println("optionalStr.get()=" + optionalStr.get());
//      System.out.println("optionalNul:"+optionalNul);
        System.out.println("optionalListStr=" + optionalListStr);
        System.out.println("optionalListStr.get()=" + optionalListStr.get());

        System.out.println();

        if (optionalStr.isPresent()) {
            System.out.println("testIsPresent:" + optionalStr.get());
        }

        optionalStr.ifPresent(System.out::println);

        System.out.println("猜猜我是谁： " + optionalStr.orElse("你不存在呀"));

        optionalStr = Optional.of("Hello Optional.isPresent");
        System.out.println("optionalStr.map:  " + optionalStr.map(a -> a.toLowerCase())
                .orElse("No value found"));


        Optional<String> s2 = optionalStr.filter(a -> a.length() > 9);
        System.out.println(s2.orElse("optionalStr.filter: ") + optionalStr.filter(a -> a.length() > 9)
                .orElse("No value found"));
    }
}

