package com.pupu.demo09.prox.staic;

/**
 * @author lipu
 * @since 2020-08-19 10:48:58
 */
public class Hello implements IHelloService {
    @Override
    public void sayHello() {
        System.out.println("Hello pupu!");
    }
}
