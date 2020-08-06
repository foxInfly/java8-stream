package com.pupu.encryptionAndSecurity.demo01.Hmac;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import java.math.BigInteger;

/**
 * Hmac
 *
 * @author lipu
 * @since 2020-08-06 13:58:26
 */
public class Demo01Hmac {

    public static void main(String[] args) throws Exception{

        // KeyGenerator:HmacMD5\HmacSHA-1\HmacSHA-256\HmacSHA-512
        KeyGenerator keyGen = KeyGenerator.getInstance("HmacMD5");
        //生成秘钥
        SecretKey key = keyGen.generateKey();
        // 打印随机生成的key:
        byte[] skey = key.getEncoded();
        System.out.println(new BigInteger(1, skey).toString(16));
        //通过名称HmacMD5获取Mac实例；
        Mac mac = Mac.getInstance("HmacMD5");
        //用SecretKey初始化Mac实例；
        mac.init(key);
        //对Mac实例反复调用update(byte[])输入数据；
        mac.update("HelloWorld".getBytes("UTF-8"));
        //调用Mac实例的doFinal()获取最终的哈希值。
        byte[] result = mac.doFinal();
        System.out.println(new BigInteger(1, result).toString(16));
    }
}
