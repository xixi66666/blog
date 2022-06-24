package com.example.demo.mapper;

import com.example.demo.bean.BlogInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface HandOnBlogMapper {

    @Select("select * from blog_info where ID = #{id}")
    public BlogInfo findBlogByBlogID(long id);

    @Select("select * from blog_info order by date desc")
    public BlogInfo[] findBlogs();

    @Insert("insert into blog_info (user_id, tag, title, description, comment_num, date, views, agree_num, draft, up, keyword) " +
            "values(#{blog.userId}, #{blog.tag}, #{blog.title}, #{blog.description}, #{blog.commentNum}, #{blog.date}, #{blog.views}, #{blog.agreeNum}, #{blog.draft}, #{blog.up}, #{blog.keyword})")
    public void insertBlog(@Param("blog") BlogInfo blogInfo);

    @Update("update blog_info set agree_num = agree_num + 1 where ID = #{id}")
    public void addAgreeNum(long id);

    @Select("select agree_num from blog_info where ID = #{id}")
    public long getAgreeNum(long id);

    @Update("update blog_info set comment_num = comment_num + 1 where ID = #{id}")
    public void addCommentNum(long id);

    @Update("update blog_info set comment_num = comment_num - 1 where ID = #{id}")
    public void reduceCommentNum(long id);

    @Select("select comment_num from blog_info where ID = #{id}")
    public long getCommentNum(long id);

    @Select("select views from blog_info where ID = #{id}")
    public long getViewNum(long id);

    @Update("update blog_info set views = views + 1 where ID = #{id}")
    public void addViewNum(long id);

    @Update("update blog_info set tag = #{blog.tag}, title = #{blog.title}, description = #{blog.description}, date = #{blog.date}, draft = 0 where ID = #{blog.ID}")
    public void updateBlogFromDraftToFormal(@Param("blog") BlogInfo blogInfo);

    @Update("update blog_info set tag = #{blog.tag}, title = #{blog.title}, description = #{blog.description}, date = #{blog.date}, draft = 1 where ID = #{blog.ID}")
    public void updateBlogFromDraftToDraft(@Param("blog") BlogInfo blogInfo);

    @Select("select User_name from user_info")
    public List<String> loadAllUser();

    @Select("select * from blog_info order by views desc limit 0, 5")
    public BlogInfo[] findBlogsByView();

}
