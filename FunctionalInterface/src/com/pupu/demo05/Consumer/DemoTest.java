package com.pupu.demo05.Consumer;

import java.util.function.Consumer;

/**
 * @author : lipu
 * @since : 2020-08-04 22:40
 */
public class DemoTest {

    public static void main(String[] args) {
        String[] arr = {"迪丽热巴,女","马尔扎哈,男","古力娜扎,女"};

        printInfo(arr,t->{
            System.out.print("姓名："+t.split(",")[0]);
        },t->{
            System.out.println("，性别："+t.split(",")[1]+"。");
        });
    }

    private static void printInfo(String[] arr,Consumer<String> consumer1,Consumer<String> consumer2){
        for (String s : arr) {
            consumer1.andThen(consumer2).accept(s);
        }
    }
}
