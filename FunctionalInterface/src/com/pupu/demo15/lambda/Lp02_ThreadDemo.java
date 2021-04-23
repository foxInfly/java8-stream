package com.pupu.demo15.lambda;

/**
 * lambda就是闲了一个指定接口的实例
 * @author lp
 * @since 2021-04-23 16:09:50
 */
public class Lp02_ThreadDemo {


    public static void main(String[] args) {
        Runnable ok = new Runnable() {
            @Override
            public void run() {
                System.out.println("ok");
            }
        };
        new Thread(ok).start();

        //jdk8
        Object ok1 = (Runnable)() -> System.out.println("ok");
        Runnable ok2 = () -> System.out.println("ok");
        System.out.println(ok1 == ok2);//false
//        new Thread(ok1);
    }
}
