package com.example.demo.controller;

import com.example.demo.bean.User;
import com.example.demo.service.USService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.websocket.Session;

@Controller
public class UserSearchController {
    @Autowired
    private USService usService;


//    开始搜索
    @RequestMapping(value = "/startUserSearch",method = RequestMethod.GET)
    @ResponseBody
    public User startUserSearch(int User_id) {
        User result = usService.userSearch(User_id);
        if (result != null) return result;
        else return null;
    }

    @RequestMapping("/searchResult")
    public String show() {
        return "searchResult";
    }
}
