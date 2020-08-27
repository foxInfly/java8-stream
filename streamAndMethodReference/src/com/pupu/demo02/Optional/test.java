package com.pupu.demo02.Optional;

import java.util.Random;

/**
 * @author lipu
 * @since 2020-08-25 10:00:56
 */
public class test {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            String s = String.valueOf(new Random().nextInt(10000000));
            System.out.println(s);
        }

    }
}
