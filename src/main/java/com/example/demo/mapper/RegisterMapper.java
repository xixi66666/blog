package com.example.demo.mapper;

import com.example.demo.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface RegisterMapper
{
    @Insert("insert into user_info (User_name, password, email, phone) values(#{user.User_name}, #{user.password}, #{user.email}, #{user.phone})")
    public int insertNewClient(@Param("user") User user);

    @Select("select User_ID from user_info where User_name = #{userName}")
    public int findUserIDByName(String userName);

}
