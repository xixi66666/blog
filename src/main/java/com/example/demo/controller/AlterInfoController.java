package com.example.demo.controller;

import com.example.demo.bean.User;

import com.example.demo.service.implement.AlterInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class AlterInfoController {

    @Autowired
    private AlterInfoServiceImpl alterInfoServiceImpl;

    @RequestMapping("/infoChange")
    public String editingOut() {
        return "/infoChange.html";
    }

    @RequestMapping("/editingIn")
    @ResponseBody
    public void editing(//@RequestParam String email,
                        @RequestParam Integer sex,
                        @RequestParam String User_name,
                        //@RequestParam Date birthday,
                        @RequestParam String email,
                        @RequestParam String firstname,
                        @RequestParam String lastname,
                        HttpSession session) throws ParseException {
        User uid = (User) session.getAttribute("user");
        Integer id = uid.getUser_ID();
        User user = new User();
//        DateFormat format= new SimpleDateFormat("yyyyMMddHHmmss");
//        Date date=format.parse(String.valueOf(birthday));
//        user.setBirthday(birthday);
        user.setUser_ID(id);
        user.setUser_name(User_name);
        user.setSex(sex);
        user.setEmail(email);
        user.setFirstname(firstname);
        user.setLastname(lastname);
        alterInfoServiceImpl.AlterInfo(user);
    }

    @RequestMapping("/resetPassword")
    @ResponseBody
    public int resetPassword(@RequestParam String password, @RequestParam String phone, @RequestParam String code,  HttpSession httpSession) {
        String codeSend = (String) httpSession.getAttribute(phone);
        if (!codeSend.equals(code))
            return -1;
        httpSession.removeAttribute(phone);
        User user = new User(0, null, password, 0, null, phone, null, null, null, 0, null, null, 0, 0, null, 0, null, 0, 0);
        alterInfoServiceImpl.resetPassword(user);
        return 1;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder, WebRequest request) {
        //转换日期 注意这里的转化要和传进来的字符串的格式一直 如2015-9-9 就应该为yyyy-MM-dd
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));// CustomDateEditor为自定义日期编辑器
    }

}
