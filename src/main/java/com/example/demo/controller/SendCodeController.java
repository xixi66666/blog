package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.zhenzi.sms.ZhenziSmsClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Controller
public class SendCodeController {

    //短信平台相关参数
    //这个不用改
    private String apiUrl = "https://sms_developer.zhenzikj.com";
    //榛子云系统上获取
    private String appId = "109987";
    private String appSecret = "c40aa12c-e40f-4d78-8e27-5274ded00f2a";

    @ResponseBody
    @RequestMapping("/sendCode")
    public boolean getCode(String phone, HttpSession httpSession){
        try {
            JSONObject json = null;
            //随机生成验证码
            String code = String.valueOf(new Random().nextInt(999999));
            //将验证码通过榛子云接口发送至手机
            ZhenziSmsClient client = new ZhenziSmsClient(apiUrl, appId, appSecret);
            Map<String, Object> params = new HashMap<String, Object>();
            //前台输入的手机号
            params.put("number", phone);
            //这个模板id对应的是榛子云个人中心的模板id
            params.put("templateId", 6747);
            String[] templateParams = new String[2];
            templateParams[0] = code;
            templateParams[1] = "5分钟";
            params.put("templateParams", templateParams);
            String result = client.send(params);
            System.out.println(result);
            json = JSONObject.parseObject(result);
            if (json.getIntValue("code")!=0){//发送短信失败
                return  false;
            }
            httpSession.setAttribute(phone,code);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
