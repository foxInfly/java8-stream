package com.pupu.demo06.Predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 *
 * 数组当中有多条“姓名+性别”的信息如下，请通过 Predicate 接口的拼装将符合要求的字符串筛选到集合ArrayList 中，需要同时满足两个条件：
 * 	1. 必须为女生；
 * 	2. 姓名为4个字。
 *
 * @author : lipu
 * @since : 2020-08-04 23:07
 */
public class DemoTest {

    public static void main(String[] args) {
        String[] arr = {"迪丽热巴,女","马尔扎哈,男","古力娜扎,女"};

        List<String> list = filter(arr, t -> "女".equals(t.split(",")[1]),
                t -> t.split(",")[0].length() == 4);
        System.out.println(list);
    }


    private static List<String> filter(String[] arr, Predicate<String> predicate1,Predicate<String> predicate2){
        ArrayList<String> list = new ArrayList<>();
        for (String info : arr) {
            if (predicate1.and(predicate2).test(info)) {
                list.add(info);
            }
        }
        return list;
    }
}
