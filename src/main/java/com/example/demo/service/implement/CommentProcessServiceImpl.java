package com.example.demo.service.implement;

import com.example.demo.bean.Comment;
import com.example.demo.mapper.CommentProcessMapper;
import com.example.demo.service.CommentProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentProcessServiceImpl implements CommentProcessService {

    @Autowired
    private CommentProcessMapper commentProcessMapper;

    @Override
    public Comment[] loadCommentsByBlogID(long id) {
        return commentProcessMapper.loadCommentsByBlogID(id);
    }

    @Override
    public void insertComment(Comment comment) {
        commentProcessMapper.insertComment(comment);
    }

    @Override
    public String findUserNameByID(long id) {
        return commentProcessMapper.findUserNameByID(id);
    }

    @Override
    public void deleteComment(long id, String description) {
        commentProcessMapper.deleteComment(id, description);
    }
}
