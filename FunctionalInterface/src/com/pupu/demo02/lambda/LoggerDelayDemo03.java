package com.pupu.demo02.lambda;

/**
 * 使用Lambda优化日志案例：延迟加载
 *
 * @author : lipu
 * @since : 2020-08-04 21:33
 */
public class LoggerDelayDemo03 {

    public static void showLog(int level, MessageBuilder message){
        //对日志级别进行判断，如果是1级别，name输出日志信息
        if (level == 1) {
            System.out.println(message.builderMessage());
        }
    }

    public static void main(String[] args) {
        //定义三个日志信息
        String msg1 = "Hello ";
        String msg2 = "World ";
        String msg3 = "Java";

        showLog(2,()->{
            System.out.println("Lambda执行");return msg1+msg2+msg3;});
    }
}
