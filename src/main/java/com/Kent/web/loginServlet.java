package com.Kent.web;

import com.Kent.mapper.UserMapper;
import com.Kent.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 接收用戶名及密碼
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        // 2. 調用 MyBatis 完成查詢
        // 2.1 取得 SqlSessionFactory 物件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2.2 取得 SqlSession 物件
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 2.3 取得 Mapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        // 2.4 調用方法
        User user = userMapper.select(username, password);

        // 2.5 釋放資源
        sqlSession.close();

        // 取得字元輸出，並設定對應的 Content type
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        // 3. 判斷 User 是否為 null
        if (user != null ){
            // 登入成功
            writer.write("登入成功");
        } else {
            // 登入失敗
            writer.write("登入失敗");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}