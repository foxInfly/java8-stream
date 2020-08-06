package com.pupu.encryptionAndSecurity.demo01.aes;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.GeneralSecurityException;
import java.util.Base64;

/**
 *
 * AES加密
 * @author : lipu
 * @since : 2020-08-06 20:16
 */
public class Demo01AES {
    public static void main(String[] args) throws Exception {
        // 原文:
        String message = "Hello, world!";
        System.out.println("原文: " + message);

        // 128位密钥 = 16 bytes Key:
        byte[] key = "1234567890abcdef".getBytes("UTF-8");

        // 加密:
        byte[] data = message.getBytes("UTF-8");
        byte[] encrypted = encrypt(key, data);
        System.out.println("加密后的密文: " + Base64.getEncoder().encodeToString(encrypted));
        // 解密:
        byte[] decrypted = decrypt(key, encrypted);
        System.out.println("解密后的密文: " + new String(decrypted, "UTF-8"));
    }

    /**
     *  加密:
     * @param key 128位秘钥
     * @param input 原文
     *
     * @author lipu
     * @since 2020/8/6 20:19
     */
    public static byte[] encrypt(byte[] key, byte[] input) throws GeneralSecurityException {
        //根据算法名称/工作模式/填充模式获取Cipher实例；
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");

        //根据算法名称初始化一个SecretKey实例，密钥必须是指定长度；
        SecretKey keySpec = new SecretKeySpec(key, "AES");

        //使用SerectKey初始化Cipher实例，并设置加密或解密模式；
        cipher.init(Cipher.ENCRYPT_MODE, keySpec);

        return cipher.doFinal(input);
    }

    //

    /**解密:
     *
     * @param key 128位秘钥
     * @param input 密文
     *
     *
     * @author lipu
     * @since 2020/8/6 20:23
     */
    public static byte[] decrypt(byte[] key, byte[] input) throws GeneralSecurityException {
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        SecretKey keySpec = new SecretKeySpec(key, "AES");

        //使用SerectKey初始化Cipher实例，并设置加密或解密模式；
        cipher.init(Cipher.DECRYPT_MODE, keySpec);
        return cipher.doFinal(input);
    }
}
