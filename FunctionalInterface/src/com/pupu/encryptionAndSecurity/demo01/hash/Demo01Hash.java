package com.pupu.encryptionAndSecurity.demo01.hash;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * @author lipu
 * @since 2020-08-05 15:46:25
 */
public class Demo01Hash {

    public static void main(String[] args) throws Exception {
        // 创建一个MessageDigest实例:MD5\SHA-1\SHA-256\SHA-512\
        MessageDigest md = MessageDigest.getInstance("MD5");
//        MessageDigest md = MessageDigest.getInstance("SHA-1");
//        MessageDigest md = MessageDigest.getInstance("SHA-256");
//        MessageDigest md = MessageDigest.getInstance("SHA-512");
        // 反复调用update(byte[])输入数据。当输入结束后，调用digest()方法获得byte[]数组表示的摘要，最后，把它转换为十六进制的字符串。
        md.update("Hello".getBytes("UTF-8"));
        md.update("World".getBytes("UTF-8"));
        byte[] result = md.digest(); // 16 bytes: 68e109f0f40ca72a15e05cc22786f8e6
        System.out.println(new BigInteger(1, result).toString(16));
        System.out.println(new BigInteger(1, result).toString(10));
        System.out.println(new BigInteger(1, result).toString(2));
    }
}
