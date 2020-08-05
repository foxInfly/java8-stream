package com.pupu.demo01.Stream;

import java.util.ArrayList;

/**
 * @author : lipu
 * @since : 2020-08-05 07:53
 */
public class Demo02StreamFilter {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("张无忌");
        list.add("周芷若");
        list.add("赵敏");
        list.add("张强");
        list.add("张三丰");

        ArrayList<String> A = new ArrayList<>();
        ArrayList<String> B = new ArrayList<>();
        list.stream().filter(s->s.startsWith("张")).forEach(a->A.add(a));
        list.stream().filter(s->s.length()==3).forEach(a->B.add(a));
        System.out.println(A);
        System.out.println(B);
    }
}
