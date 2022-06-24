package com.example.demo.mapper;

import com.example.demo.bean.BlogInfo;
import com.example.demo.bean.FriendList;
import com.example.demo.bean.RequestList;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PersonMainPageMapper {
    //    查询某一用户的所有博客
    @Select("select * from blog_info where user_id=#{user_id} order by date desc")
    public List<BlogInfo> getOnesTotalBlogs(int user_id);
}
