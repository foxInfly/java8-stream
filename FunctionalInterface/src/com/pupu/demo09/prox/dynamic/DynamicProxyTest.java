package com.pupu.demo09.prox.dynamic;

import com.pupu.demo09.prox.staic.Hello;
import com.pupu.demo09.prox.staic.IHelloService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * 动态代理步骤：
 *  1.通过实现 InvocationHandler 接口创建自己的调用处理器   就是要代理成啥样；
 *  2.通过为 Proxy 类指定 ClassLoader 对象和一组 interface 来创建动态代理类；
 *  3.通过反射机制获得动态代理类的构造函数，其唯一参数类型是调用处理器接口类型；
 *  4.通过构造函数创建动态代理类实例，构造时调用处理器对象作为参数被传入。
 *
 * @author lipu
 * @since 2020-08-19 10:56:52
 */
public class DynamicProxyTest {

    public static void main(String[] args) {
        System.getProperties().setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        IHelloService hello = new Hello();
        IByeService byeService = new ByeServiceImpl();

        InvocationHandler handler = new ProxyHandler(hello);
        InvocationHandler handler1 = new ProxyHandler(byeService);

        //生成代理实例
        IHelloService proxyHello = (IHelloService) Proxy.newProxyInstance(hello.getClass().getClassLoader(), hello.getClass().getInterfaces(), handler);
        IByeService byeService1 = (IByeService) Proxy.newProxyInstance(byeService.getClass().getClassLoader(), byeService.getClass().getInterfaces(), handler1);

        proxyHello.sayHello();
        byeService1.sayBye();
        byeService1.sayBye1();
    }
}
