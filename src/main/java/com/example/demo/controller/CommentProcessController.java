package com.example.demo.controller;

import com.example.demo.bean.Comment;
import com.example.demo.service.implement.CommentProcessServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.Timestamp;
import java.util.Date;

@Controller
public class CommentProcessController {

    @Autowired
    private CommentProcessServiceImpl commentProcessService;

    @RequestMapping("/loadComments/{blogid}")
    @ResponseBody
    public Comment[] loadComments(@PathVariable("blogid") long id) {
        return commentProcessService.loadCommentsByBlogID(id);
    }

    @RequestMapping("/insertNewComment")
    @ResponseBody
    public void inserNewComment(@RequestBody String data) {
        try {
            String[] decode = URLDecoder.decode(data, "utf-8").split("&");
            for (int i = 0; i < decode.length; i++) {
                decode[i] = decode[i].substring(decode[i].indexOf("=") + 1);
            }
            Comment comment = new Comment(new Long(0), Long.parseLong(decode[0]), Long.parseLong(decode[1]), Long.parseLong(decode[1]), new Long(0), new Timestamp(new Date().getTime()), decode[2]);
            commentProcessService.insertComment(comment);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }

    @RequestMapping("/findUserNameByID/{id}")
    @ResponseBody
    public String findUserNameByID(@PathVariable("id") long id) {
        return commentProcessService.findUserNameByID(id);
    }

    @RequestMapping("/deleteComment")
    @ResponseBody
    public void deleteComment(@RequestBody String data) {
        try {
            String[] decode = URLDecoder.decode(data, "utf-8").split("&");
            for (int i = 0; i < decode.length; i++) {
                decode[i] = decode[i].substring(decode[i].indexOf("=") + 1);
            }
            commentProcessService.deleteComment(Long.parseLong(decode[0]), decode[1]);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }
}
