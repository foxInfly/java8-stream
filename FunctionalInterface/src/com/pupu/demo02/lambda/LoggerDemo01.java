package com.pupu.demo02.lambda;

/**
 * 日志案例
 *      以下代码存在性能浪费,msg1+msg2+msg3不管执不执行，都会走字符串拼装
 * @author : lipu
 * @since : 2020-08-04 20:37
 */
public class LoggerDemo01 {

    public static void showLog(int level, String message){
        //对日志级别进行判断，如果是1级别，name输出日志信息
        System.out.println(message);
        if (level == 1) {
            System.out.println(message);
        }
    }

    public static void main(String[] args) {
        //定义三个日志信息
        String msg1 = "Hello";
        String msg2 = "World";
        String msg3 = "Java";

        showLog(2,msg1+msg2+msg3);
    }
}
