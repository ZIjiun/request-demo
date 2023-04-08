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

@WebServlet("/registerServlet")
public class registerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //  1. 接收用戶資料
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        // 封裝用戶物件
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        //  2. 調用 mapper，根據用戶名查詢用戶物件
        // 2.1 取得 SqlSessionFactory 物件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2.2 取得 SqlSession 物件
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 2.3 取得 Mapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        // 2.4 調用方法
        User u = userMapper.selectByUsername(username);

        if (u == null) {
            System.out.println(user.getUsername());
            // 用戶名不存在，增加用戶
            userMapper.add(user);
            // 提交交易
            sqlSession.commit();

            // 釋放資源
            sqlSession.close();
        } else {
            // 用戶名存在，給出提示訊息
            resp.setContentType("text/html;charset=utf-8");
            resp.getWriter().write("用戶名已存在");
        }

        // 2.5 釋放資源
        sqlSession.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}