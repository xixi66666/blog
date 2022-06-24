package com.example.demo.controller;

import com.example.demo.bean.BlogInfo;
import com.example.demo.service.implement.PMPageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class PMPageController {

    @Autowired
    private PMPageServiceImpl pageService;

    //  获取某个人全部博客
    @ResponseBody
    @RequestMapping(value = "/getOnesTotalBlogs",method = RequestMethod.GET)
    public List<BlogInfo> getOnesTotalFriends(int user_id){
//        System.out.println(pageService.getOnesTotalBlogs(user_id));
        return pageService.getOnesTotalBlogs(user_id);
    }

    @RequestMapping("/personPage")
    public String show() {

        return "personPage.html";
    }
}
