package com.Kent.web.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 響應字元資料: 設置字元資料的響應體
 */
@WebServlet("/resp3")
public class ResponseDemo3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 同時設定 content-type，以及流的編碼是 utf-8
        resp.setContentType("text/html;charset=utf-8");

        // 1. 取得字元輸出流
        PrintWriter writer = resp.getWriter();

        // content-type
//        resp.setHeader("content-type", "text/html");

        writer.write("aaa");
        writer.write("你好");
        writer.write("<h1>aaa<h1>");

        // 細節: 流不需要關閉

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}