package com.Kent.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/req1")
public class RequestDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // String getMethod(): 取得請求方式: GET
        String method = req.getMethod();
        System.out.println(method); //GET

        //String getContextPath(): 取得虛擬目錄(專案訪問路徑): /request-demo
        String contextPath = req.getContextPath();
        System.out.println(contextPath);

        // StringBuffer getRequestURL(): 取得 URL(統一資源定位符): http://localhost:8080/request-demo/req1
        StringBuffer url  = req.getRequestURL();
        System.out.println(url.toString());

        // String getResource(): 取得URI(統一資源標示符): /request-demo/req1
        String uri = req.getRequestURI();
        System.out.println(uri);

        // String getQueryString(): 取得請求參數(GET方式): username=kevin
        String queryString = req.getQueryString();
        System.out.println(queryString);

        // 取得請求頭: user-agent: 瀏覽器的版本訊息
        String agent = req.getHeader("user-agent");
        System.out.println(agent);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 取得 post 請求體: 請求參數

        // 1. 取得字符輸入流(要取出的內容都是字串)
        BufferedReader br = req.getReader();
        // 2. 讀取數據
        String line = br.readLine();
        System.out.println(line);
    }
}