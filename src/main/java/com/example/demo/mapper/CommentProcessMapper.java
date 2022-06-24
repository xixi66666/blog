package com.example.demo.mapper;

import com.example.demo.bean.Comment;
import org.apache.ibatis.annotations.*;

@Mapper
public interface CommentProcessMapper {

    @Select("select * from comment where blog_id = #{id} order by date desc")
    public Comment[] loadCommentsByBlogID(long id);

    @Insert("insert into comment (user1, blog_id, baba_id, agree_num, date, description) values(#{comment.user1}, #{comment.blogId}, #{comment.babaId}, #{comment.agreeNum}, #{comment.date}, #{comment.description})")
    public void insertComment(@Param("comment") Comment comment);

    @Select("select User_name from user_info where User_ID = #{id}")
    public String findUserNameByID(long id);

    @Delete("delete from comment where blog_id = #{blogid} and description = #{description}")
    public void deleteComment(@Param("blogid") long id, @Param("description") String description);
}
