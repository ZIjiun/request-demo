package com.Kent.web.response;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 回應 byte 資料: 設置 byte 資料的響應體
 */
@WebServlet("/resp4")
public class ResponseDemo4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 讀取文件
        FileInputStream fis = new FileInputStream("C:\\Users\\s4101\\Desktop\\JavaWeb_code\\request-demo\\src\\main\\resources\\a.jpg");

        // 2. 獲取 response 字節輸出流
        ServletOutputStream os = resp.getOutputStream();

        // 3. 完成流的 copy
//        byte[] buff = new byte[1024];
//        int len = 0;
//        while ((len = fis.read(buff)) != -1) {
//            os.write(buff, 0, len);
//        }

        IOUtils.copy(fis, os);

        fis.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}