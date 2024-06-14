package org.example.userservice.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.example.userservice.po.User;

import java.util.List;

public interface SignMapper {
    @Select("select s.password as password from Users s where username = #{username}")
    String findPwdByName(@Param("username")String username);

    @Insert("insert into Users(username,password) values(#{username},#{password})")
    void insertSign(User user);
}
