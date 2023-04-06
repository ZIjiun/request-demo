package com.Kent.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * 中文亂碼問題解決方案
 */
@WebServlet("/req3")
public class RequestDemo3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 解決亂碼: POST, getReader()
        // 網頁使用 UTF-8，因此這邊也設定成 UTF-8
        req.setCharacterEncoding("UTF-8"); // 設置字符輸入流的編碼

        // 2. 取得 username
        String username = req.getParameter("username");
        System.out.printf("解決亂碼前%s%n", username);

        // 3. GET，獲取參數的方式: getQueryString
        // 亂碼原因: tomcat 進行 URL編時，預設的字符集是 ISO-8859-1
        // 3.1 先對亂碼資料進行編碼: 轉為字節陣列
//        byte[] bytes = username.getBytes(StandardCharsets.ISO_8859_1);
        // 3.2 字節陣列解碼
//        username = new String(bytes, "utf-8");

        // 合併起來
        username = new String(username.getBytes(StandardCharsets.ISO_8859_1), "utf-8");

        System.out.printf("解決亂碼後%s%n", username);

//        解決亂碼前å°æ
//        解決亂碼後小明

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}