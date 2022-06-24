package com.example.demo.mapper;

import com.example.demo.bean.Tag;
import com.example.demo.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserSearchMapper {
//    根据UID搜索用户
    @Select("select * from user_info where User_ID=#{User_ID}")
    public User getByUID(int User_ID);
}
