package com.pupu.demo1.FuncationalInterface;

/**
 * 函数是接口的使用：
 *      1.作为参数
 *      2.作为返回值
 *
 * @author : lipu
 * @since : 2020-08-04 20:20
 */
public class Demo {

    //定义一个方法，参数使用函数是接口MyfunctionaInterface
    public static void show(MyfunctionaInterface myInter){
        myInter.myMethod();
    }

    public static void main(String[] args) {
        //传递其实现类
        show(new MyfunctionaInterfaceImpl());

        //直接传递匿名内部类
        show(new MyfunctionaInterface() {
            @Override
            public void myMethod() {
                System.out.println("我是MyfunctionaInterface的匿名内部实现类");
            }
        });

        //使用Lambda表达式
        show(()->{
            System.out.println("使用完整的Lambda表达式重写接口的方法");
        });
        show(()-> System.out.println("使用简化的Lambda表达式重写接口的方法"));
    }
}
