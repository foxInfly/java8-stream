package com.pupu.demo09.prox.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 代理程序控制器
 * @author lipu
 * @since 2020-08-19 10:54:54
 */
public class ProxyHandler implements InvocationHandler {

    private Object object;

    public ProxyHandler(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Before invoke "+method.getName());
        method.invoke(object,args);
        System.out.println("After invoke "+method.getName());


        return null;
    }
}
