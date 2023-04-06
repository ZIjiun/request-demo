package com.Kent.web.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/resp1")
public class ResponseDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("resp1...");

//        // 重定向
//        // 1. 設定響應狀態碼 302
//        resp.setStatus(302);
//        // 2. 設定響應頭
//        resp.setHeader("Location", "/request-demo/resp2");

        // 簡化方式完成重定向
        resp.sendRedirect("/request-demo/resp2");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}