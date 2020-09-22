package com.pupu.encryptionAndSecurity.demo01.demo3_hash;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * @author lipu
 * @since 2020-08-05 15:46:25
 */
public class Demo01Hash {

    public static void main(String[] args) throws Exception {
        // 创建一个MessageDigest实例:MD5\SHA-1\SHA-256\SHA-512\
        MessageDigest md = MessageDigest.getInstance("MD5");//短了，目前已不推荐使用
        MessageDigest md1 = MessageDigest.getInstance("SHA-1");
        MessageDigest md2 = MessageDigest.getInstance("SHA-256");
//        MessageDigest md = MessageDigest.getInstance("SHA-512");
        // 反复调用update(byte[])输入数据。当输入结束后，调用digest()方法获得byte[]数组表示的摘要，最后，把它转换为十六进制的字符串。
        md.update("Hello World".getBytes("UTF-8"));
        md1.update("Hello World".getBytes("UTF-8"));
        md2.update("Hello World".getBytes("UTF-8"));
        byte[] result = md.digest();   // 16 bytes: 68e109f0f40ca72a15e05cc22786f8e6
        byte[] result1 = md1.digest(); // 20 bytes: a4d55a8d778e5022fab701977c5d840bbc486d0
        byte[] result2 = md2.digest(); // 32 bytes: a591a6d40bf420404a011733cfb7b190d62c65bf0bcda32b57b277d9ad9f146e
        System.out.println(new BigInteger(1, result).toString(16));//16进制
        System.out.println(new BigInteger(1, result).toString(10));//10进制
        System.out.println(new BigInteger(1, result).toString(2));//2进制
        System.out.println(new BigInteger(1, result1).toString(16));//16进制
        System.out.println(new BigInteger(1, result2).toString(16));//16进制
    }
}
