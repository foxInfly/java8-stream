package com.pupu.encryptionAndSecurity.demo01.demo4_Hmac;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.math.BigInteger;

/**
 * Hash-based Message Authentication Code
 * 是一种更安全的消息摘要算法。
 * HmacMD5使用的key长度是64字节，更安全；
 * Hmac是标准算法，同样适用于SHA-1等其他哈希算法；
 * Hmac输出和原有的哈希算法长度一致。
 *
 * @author lipu
 * @since 2020-08-06 13:58:26
 */
public class Demo01Hmac {

    public static void main(String[] args) throws Exception{

        // KeyGenerator:HmacMD5\HmacSHA-1\HmacSHA-256\HmacSHA-512
        //生成一个安全随机的key(盐)对象
        KeyGenerator keyGen = KeyGenerator.getInstance("HmacMD5");
        //生成秘钥key(盐)
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


        //====验证：
        SecretKey key1 = new SecretKeySpec(key.getEncoded(), "HmacMD5");
        System.out.println(new BigInteger(1, key1.getEncoded()).toString(16));
    }
}
