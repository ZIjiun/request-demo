package com.Kent.mapper;


import com.Kent.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    /**
     * 根據用戶名和密碼查詢用戶對象
     * @param username
     * @param password
     * @return
     */
    @Select("select * from tb_user where username = #{username} and password = #{password}")
    User select(@Param("username") String username, @Param("password") String password);

    /**
     * 根據用戶名查詢用戶物件
     * @param username
     * @return
     */
    @Select("select * from tb_user where username = #{username}")
    User selectByUsername(String username);

    /**
     * 增加用戶
     * @param user
     */
    @Insert("INSERT into tb_user values(null, #{username}, #{password})")
    void add(User user);
}
