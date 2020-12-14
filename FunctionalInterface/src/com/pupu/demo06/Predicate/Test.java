package com.pupu.demo06.Predicate;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author lp
 * @since 2020-12-14 10:47:32
 */
public class Test {

    public static void main(String[] args) {
        List<Map<String,Object>> resultList = new ArrayList<>();
        List<Map<String,Object>> list = new ArrayList<>();
        Map<String,Object> map1 = new HashMap<>();
        map1.put("alarmType","9");
        list.add(map1);
        Map<String,Object> map2 = new HashMap<>();
        map2.put("alarmType","8");
        list.add(map2);
        Map<String,Object> map3 = new HashMap<>();
        map3.put("alarmType","7");
        list.add(map3);
        // 禹州大屏过滤 重点设备房报警
        Predicate<Map> alarmTypeFilter = (t) -> ( !Objects.equals(t.get("alarmType").toString(), "9"));
        List<Map<String, Object>> maps = list.stream().filter(alarmTypeFilter).collect(Collectors.toList());
        for (Map<String, Object> map : maps) {
            System.out.println(map);
        }
    }
}
