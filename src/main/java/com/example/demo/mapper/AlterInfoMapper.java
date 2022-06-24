package com.example.demo.mapper;

import com.example.demo.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface AlterInfoMapper
{
    @Update("update user_info set User_name = #{user.User_name},sex = #{user.sex}," +
            "firstname = #{user.firstname},lastname = #{user.lastname}" +
            ",birthday = #{user.birthday}, email = #{user.email} where User_ID = #{user.User_ID}")
    public int AlterInfo(@Param("user") User user);

    @Update("update user_info set password = #{user.password} where phone = #{user.phone}")
    public void resetPassword(@Param("user") User user);
}

