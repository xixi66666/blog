package com.example.demo.controller;

import com.example.demo.bean.User;
import com.example.demo.service.implement.RegisterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.Date;

@Controller
public class RegisterController
{
    @Autowired
    private RegisterServiceImpl registerService;

    @RequestMapping(value = "/registerAccount", method = RequestMethod.POST)
    @ResponseBody
    public int test(String User_name, String password, String repeat_password, String phone, String code, String email, HttpSession httpSession)
    {
        String codeSend = (String) httpSession.getAttribute(phone);
        if (codeSend == null || !codeSend.equals(code))
            return -1;
        httpSession.removeAttribute(phone);
        User user = new User(0, User_name, password, 0, email, phone, null, null, null, 0, new Timestamp(new Date().getTime()), new Timestamp(new Date().getTime()), 0, 0, new Timestamp(new Date().getTime()), 0, "在线", 0, 0);
        registerService.insertNewClient(user);
        return registerService.findUserIDByName(User_name);

    }



}
