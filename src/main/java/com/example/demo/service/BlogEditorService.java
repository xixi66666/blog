package com.example.demo.service;

import com.example.demo.bean.BlogInfo;

import java.util.List;

public interface BlogEditorService {

    public BlogInfo findBlogByBlogID(long id);

    public void insertBlog(BlogInfo blogInfo);

    public void addAgreeNum(long id);

    public long getAgreeNum(long id);

    public void addCommentNum(long id);

    public void reduceCommentNum(long id);

    public long getCommentNum(long id);

    public long getViewNum(long id);

    public void addViewNum(long id);

    public BlogInfo[] findBlogs();

    public void updateBlogFromDraftToFormal(BlogInfo blogInfo);

    public void updateBlogFromDraftToDraft(BlogInfo blogInfo);

    public List<String> loadAllUser();

    public BlogInfo[] findBlogsByView();

}
