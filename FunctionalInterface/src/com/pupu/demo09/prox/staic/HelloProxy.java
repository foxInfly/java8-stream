package com.pupu.demo09.prox.staic;

/**
 * @author lipu
 * @since 2020-08-19 10:50:38
 */
public class HelloProxy implements IHelloService {

    private IHelloService hello = new Hello();

    @Override
    public void sayHello() {
        System.out.println("before invoke sayHello");
        hello.sayHello();
        System.out.println("after invoke sayHello");
    }
}
