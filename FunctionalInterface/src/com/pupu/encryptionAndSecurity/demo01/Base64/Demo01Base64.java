package com.pupu.encryptionAndSecurity.demo01.Base64;

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
    }
}
