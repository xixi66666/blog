package com.example.demo.controller;

import com.example.demo.bean.User;
import com.example.demo.service.implement.LoginServiceImpl;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@Controller
public class LoginController {

    @GetMapping(value = {"/","/index.html"})
    public String loginPage(){
        return "index";
    }
    @GetMapping("companies.html")
    public String companies(){
        return "companies";
    }
    @GetMapping("projects.html")
    public String projects(){
        return "projects";
    }
    @GetMapping("user-profile.html")
    public String userprofile(){
        return "user-profile";
    }
    @GetMapping("profiles.html")
    public String profiles(){
        return "profiles";
    }
    @GetMapping("my-profile-feed.html")
    public String myprofile(){
        return "my-profile-feed";
    }
    @GetMapping("jobs.html")
    public String jobs(){
        return "jobs";
    }
    @GetMapping("sign-in.html")
    public String sign(){
        return "sign-in";
    }
    @GetMapping("profile-account-setting.html")
    public String account(){
        return "infoChange";
    }

    @RequestMapping("/getSession")
    public void getSession(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if(session == null){
            response.getWriter().write("用户未登录");
        }else{
            String  user_ID = (String) session.getAttribute("user");
            response.getWriter().write(user_ID);
        }
    }

    @Autowired
    LoginServiceImpl loginServiceImpl;
    @RequestMapping("/userLogin")
    @ResponseBody
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String login(@RequestParam String User_name, @RequestParam String password, HttpSession session,Model model){
        User user = new User();
        user.setUser_name(User_name);
        user.setPassword(password);
        Integer flag = loginServiceImpl.LoginCheck(user);
        System.out.println(flag);
        if(flag != null){
            user.setUser_ID(flag);
            session.setAttribute("user",user);
            return flag.toString();
        }else{
            model.addAttribute("msg","账号或密码错误");
            return null;
        }
    }

    @RequestMapping("/signIn")
    public String singIn() {
        return "sign-in.html";
    }
}
