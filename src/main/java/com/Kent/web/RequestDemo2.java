package com.Kent.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;

@WebServlet("/req2")
public class RequestDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // GET　請求邏輯
//        System.out.println("get...");

        // 1. 取得所有參數的 Map 集合
        Map<String, String[]> map = req.getParameterMap();
        for (String key: map.keySet()) {
            // username: Kevin Nina
            System.out.print(key + ":");

            // 取得值
            String[] values = map.get(key);
            for (String value: values) {
                System.out.print(value + " ");
            }

            System.out.println();
        }

//        get...
//        username:Kevin
//        password:123
//        hobby:1 2

        System.out.println("------------------");

        // 2. 根據 key 取得參數值，陣列
        String[] hobbies = req.getParameterValues("hobby");

        for(String hobby: hobbies) {
            System.out.println(hobby);
        }

        // 3. 根據 key 取得單個參數值
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        System.out.println(username);
        System.out.println(password);

//        1
//        2
//        Kevin
//        123
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // POST 請求邏輯

        // POST 跟 GET 處理 request ，只有取出請求數據的方式不同，所以用 req 包裝好的方法，可以同時取出兩種請求方式的參數，同樣的程式碼就只要寫一遍
        this.doGet(req, resp);

//        username:Kevin
//        password:123
//        hobby:1 2
//        ------------------
//        1
//        2
//        Kevin
//        123

    }
}