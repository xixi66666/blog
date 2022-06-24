package com.example.demo.service;

import com.example.demo.bean.Comment;


public interface CommentProcessService {

    public Comment[] loadCommentsByBlogID(long id);

    public void insertComment(Comment comment);

    public String findUserNameByID(long id);

    public void deleteComment(long id, String description);
}
