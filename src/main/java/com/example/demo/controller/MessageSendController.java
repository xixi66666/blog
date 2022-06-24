package com.example.demo.controller;

import com.example.demo.bean.Message;
import com.example.demo.service.implement.MessageSendServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.imageio.stream.FileImageInputStream;
import java.io.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class MessageSendController {

    @Autowired
    private MessageSendServiceImpl messageSendService;

    private List<String> users = new ArrayList<>();

    @RequestMapping("/storeMessage/{id}/{sender}/{receiver}/{content}/{image}/{date}/{isreceived}")
    @ResponseBody
    public void fromSocketToMessageBean(@PathVariable("id") long id, @PathVariable("sender") String sender, @PathVariable("receiver") String receiver, @PathVariable("content") String content, @PathVariable("image") byte[] image, @PathVariable("date") Timestamp timestamp, @PathVariable("isreceived") int isreceived) {
        long sender_ = messageSendService.findUserIDByName(sender);
        long receiver_ = messageSendService.findUserIDByName(receiver);
        Message message = new Message(1, sender_, receiver_, content, image, timestamp, 0);
        messageSendService.insertMessageRecord(message);
    }

    @RequestMapping("/searchUnreceivedRecord/{userName}")
    @ResponseBody
    public String[] searchUnreceivedRecord(@PathVariable("userName") String userName) {
        long receiver = messageSendService.findUserIDByName(userName);
        String[] unreceivedRecord = messageSendService.findUnreceivedRecord(receiver);
        List<String> list = new ArrayList<>();
        for (String str: unreceivedRecord
             ) {
            list.add(str);
        }
        return unreceivedRecord;
    }

    @ResponseBody
    @RequestMapping("/checkWebSocket/{nickname}")
    public int checkWebSocket(@PathVariable("nickname") String nickname) {
        if (users.contains(nickname))
            return 1;
        else {
            users.add(nickname);
            return 0;
        }
    }

    @ResponseBody
    @RequestMapping("/searchRelatedMessage/{username1}/{username2}")
    public Message[] searchRelatedMessage(@PathVariable("username1") String username1, @PathVariable("username2") String username2) {
        long userid1 = messageSendService.findUserIDByName(username1);
        long userid2 = messageSendService.findUserIDByName(username2);
        Message[] relatedRecord = messageSendService.findRelatedRecord(userid1, userid2);
        return relatedRecord;
    }

    @ResponseBody
    @RequestMapping("/checkForUserID/{username}")
    public long checkForUserID(@PathVariable("username") String username) {
        return messageSendService.findUserIDByName(username);
    }

    @RequestMapping("/releaseConnection/{username}")
    @ResponseBody
    public void releaseConnection(@PathVariable("username") String username) {
        users.remove(username);
        System.out.println(username + "已删除");
    }

    @RequestMapping("/chat/{nickname}")
    public String showChatPage() {
        return "/chat.html";
    }
}
