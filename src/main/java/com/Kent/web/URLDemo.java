package com.Kent.web;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class URLDemo {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String username = "小明";

        // 1. URL 編碼 (瀏覽器行為)
        String encode = URLEncoder.encode(username, "utf-8");
        System.out.println(encode);

        // tomcat7 (8版以後不會了) 使用 ISO-8859-1 的編碼方式來解碼

        // 2. URL 解碼 (tomcat 行為)
        String decode = URLDecoder.decode(encode, "ISO-8859-1");
        System.out.println(decode);

        // 3. 轉換為字節資料(編碼)
        byte[] bytes = decode.getBytes("ISO-8859-1");
        for (byte b : bytes) {
            System.out.print(b + " ");
        }

        // 4. 將字節陣列轉為字串(解碼)
        String s = new String(bytes, "utf-8");

        System.out.println(s);
    }
}
