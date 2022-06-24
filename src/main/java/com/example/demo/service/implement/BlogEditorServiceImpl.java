package com.example.demo.service.implement;

import com.example.demo.bean.BlogInfo;
import com.example.demo.mapper.HandOnBlogMapper;
import com.example.demo.service.BlogEditorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogEditorServiceImpl implements BlogEditorService {

    @Autowired
    private HandOnBlogMapper handOnBlogMapper;

    @Override
    public BlogInfo findBlogByBlogID(long id) {
        BlogInfo blogInfo = handOnBlogMapper.findBlogByBlogID(id);
        return blogInfo;
    }

    @Override
    public void insertBlog(BlogInfo blogInfo) {
        handOnBlogMapper.insertBlog(blogInfo);
    }

    @Override
    public void addAgreeNum(long id) {
        handOnBlogMapper.addAgreeNum(id);
    }

    @Override
    public long getAgreeNum(long id) {
        return handOnBlogMapper.getAgreeNum(id);
    }

    @Override
    public void addCommentNum(long id) {
        handOnBlogMapper.addCommentNum(id);
    }

    @Override
    public void reduceCommentNum(long id) {
        handOnBlogMapper.reduceCommentNum(id);
    }

    @Override
    public long getCommentNum(long id) {
        return handOnBlogMapper.getCommentNum(id);
    }

    @Override
    public long getViewNum(long id) {
        return handOnBlogMapper.getViewNum(id);
    }

    @Override
    public void addViewNum(long id) {
        handOnBlogMapper.addViewNum(id);
    }

    @Override
    public BlogInfo[] findBlogs() {
        return handOnBlogMapper.findBlogs();
    }

    @Override
    public void updateBlogFromDraftToFormal(BlogInfo blogInfo) {
        handOnBlogMapper.updateBlogFromDraftToFormal(blogInfo);
    }

    @Override
    public void updateBlogFromDraftToDraft(BlogInfo blogInfo) {
        handOnBlogMapper.updateBlogFromDraftToDraft(blogInfo);
    }

    @Override
    public List<String> loadAllUser() {
        return handOnBlogMapper.loadAllUser();
    }

    @Override
    public BlogInfo[] findBlogsByView() {
        return handOnBlogMapper.findBlogsByView();
    }
}
