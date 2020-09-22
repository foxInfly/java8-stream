package com.pupu.encryptionAndSecurity.demo01.demo1_URL;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**Java标准库提供了一个URLEncoder类来对任意字符串进行URL编码
 * @author lipu
 * @since 2020-09-22 15:49:14
 */
public class URLEncodeDemo {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String encode = URLEncoder.encode("中 文!", StandardCharsets.UTF_8.toString());
        System.out.println(encode);//%E4%B8%AD+%E6%96%87%21
        //和标准的URL编码稍有不同，URLEncoder把空格字符编码成+，
        //而现在的URL编码标准要求空格被编码为%20，不过，服务器都可以处理这两种情况。

        String decode = URLDecoder.decode(encode,StandardCharsets.UTF_8.name());
        System.out.println(decode);

        String decode1 = URLDecoder.decode(encode,StandardCharsets.UTF_8.displayName());
        System.out.println(decode1);
    }
}
