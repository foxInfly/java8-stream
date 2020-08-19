package com.pupu.demo09.prox.staic;

/**
 * @author lipu
 * @since 2020-08-19 10:53:36
 */
public class StaticProxyTest {

    public static void main(String[] args) {
        IHelloService helloService = new HelloProxy();
        helloService.sayHello();
    }
}
