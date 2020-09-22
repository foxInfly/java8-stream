package com.pupu.encryptionAndSecurity.demo01.demo2_Base64;

import java.util.Base64;

/**
 * Base64编码可以把任意长度的二进制数据变为纯文本，且只包含A~Z、a~z、0~9、+、/、=这些字符。
 *
 * 原理:
 *    把3字节的二进制数据按6bit一组，用4个int整数表示，然后查表，把int整数用索引对应到字符，得到编码后的字符串。
 *
 * 符中的UTF-8编码是0xe4b8ad，因此，它的URL编码是%E4%B8%AD。URL编码总是大写。
 *      e4=228=1110 0100
 *
 * @author lipu
 * @since 2020-08-05 14:34:04
 */
public class Demo01Base64 {

    public static void main(String[] args) {
        byte[] input = new byte[] { (byte) 0xe4, (byte) 0xb8, (byte) 0xad };
        String b64encoded = Base64.getEncoder().encodeToString(input);
        System.out.println(b64encoded);
        byte[] bytes = Base64.getDecoder().decode(b64encoded);
        System.out.println(new String(bytes));
        System.out.println("=====================================================");
        String str = "中国";
        Base64.Encoder encoder = Base64.getEncoder();//1.获取base64编码器
        String base64Str = encoder.encodeToString(str.getBytes());//2.用编译器把普通字符串编译成对应的base64字符串
        System.out.println(base64Str);
        Base64.Decoder decoder = Base64.getDecoder();//3.获取base64解码器
        byte[] decodebase64str = decoder.decode(base64Str);//4.把指定的base64字符串解码成正常的字符串；
        System.out.println(new String(decodebase64str));

    }
}
