package com.pupu.demo01.Stream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Stream;

/**
 * @author : lipu
 * @since : 2020-08-05 22:27
 */
public class Demo03Stream {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        Stream<String> stream = list.stream();

        HashMap<String, String> map = new HashMap<>();
        int[] a = {1,2,3,4};
        Stream<HashMap<String, String>> map1 = Stream.of(map);
        Stream<int[]> a1 = Stream.of(a);
    }
}
