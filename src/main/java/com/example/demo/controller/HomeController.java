package com.example.demo.controller;

import com.example.demo.bean.BlogInfo;

import com.example.demo.service.implement.BlogEditorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController
{
    @RequestMapping("/home")
    public String home(){return "/home.html";}

    @Autowired
    BlogEditorServiceImpl blogEditorService;

    @ResponseBody
    @RequestMapping("/loadBlog")
    public BlogInfo[] blog(){
        return blogEditorService.findBlogs();
    }

    @RequestMapping("/")
    public String showIndex() {
        return "/index.html";
    }

}
