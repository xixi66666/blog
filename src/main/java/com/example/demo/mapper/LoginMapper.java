package com.example.demo.mapper;


import com.example.demo.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface LoginMapper {
    @Select("select User_ID from user_info where User_name = #{User_name} and password = #{password}")
    Integer checklogin(User user);
}
