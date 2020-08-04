package com.pupu.demo01.Stream;

import java.util.ArrayList;

/**
 * @author : lipu
 * @since : 2020-08-05 07:35
 */
public class Demo01List {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("张无忌");
        list.add("周芷若");
        list.add("赵敏");
        list.add("张强");
        list.add("张三丰");

        //对list集合遍历，以张开头的元素存到一个集合，三个字的存到一个集合
        ArrayList<String> A = new ArrayList<>();
        for (String s : list) {
            if (s.startsWith("张")) {
                A.add(s);
            }
        }

        ArrayList<String> B = new ArrayList<>();
        for (String s : list) {
            if (s.length() ==3) {
                B.add(s);
            }
        }

        System.out.println(A);
        System.out.println(B);

    }
}
