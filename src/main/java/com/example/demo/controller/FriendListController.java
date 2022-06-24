package com.example.demo.controller;

import com.example.demo.bean.FriendList;
import com.example.demo.bean.RequestList;
import com.example.demo.bean.User;
import com.example.demo.service.implement.FLServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class FriendListController {
    @Autowired
    private FLServiceImpl flService;


    //  获取某个人全部好友
    @ResponseBody
    @RequestMapping(value = "/getOnesTotalFriends",method = RequestMethod.GET)
    public List<FriendList> getOnesTotalFriends(int user_id){
//        System.out.println(flService.getOnesTotalFriends(user_id));
        return flService.getOnesTotalFriends(user_id);
    }
    //  添加好友
    @ResponseBody
    @RequestMapping(value = "/newFriendShip",method = RequestMethod.POST)
    public String newFriendShip(int user_id,int friend_id){
        try {
            if(user_id != friend_id){
                FriendList friendList = new FriendList(0,user_id,friend_id);
                flService.newFriendShip(friendList);
                flService.deleteRequest(friendList);
                friendList = new FriendList(0,friend_id,user_id);
                flService.newFriendShip(friendList);
                flService.deleteRequest(friendList);
                return "添加好友成功";
            }
            else return "不能与自己是好友！";
        } catch (Exception e){
            System.out.println(e);
            return "出错了";
        }
    }
    //  删除好友
    @ResponseBody
    @RequestMapping(value = "/deleteFriendShip",method = RequestMethod.DELETE)
    public String deleteFriendShip(int user_id,int friend_id){
        try {
            if(user_id != friend_id){
                FriendList friendList = new FriendList(0,user_id,friend_id);
                flService.deleteFriendShip(friendList);
                friendList = new FriendList(0,friend_id,user_id);
                flService.deleteFriendShip(friendList);
                return "删除好友成功";
            }
            else return "不能删除自己！";
        } catch (Exception e){
            System.out.println(e);
            return "出错了";
        }
    }
    //  获取好友状态
    @ResponseBody
    @RequestMapping(value = "/getFriendStatus",method = RequestMethod.GET)
    public String getFriendStatus(int friend_id){
        try {
                return flService.getFriendStatus(friend_id);
        } catch (Exception e){
            System.out.println(e);
            return "出错了";
        }
    }
//    判断2人是否为好友
    @ResponseBody
    @RequestMapping(value = "/isFriend",method = RequestMethod.GET)
    public boolean isFriend(int frist_id,int second_id){
        try {
            List<FriendList> frist_friends = getOnesTotalFriends(frist_id);
            if(frist_id == second_id){
                return true;
            }
            for (FriendList f: frist_friends) {
                if(f.getFriend_id() == second_id) {
                    return true;
                }
            }
            return false;
        } catch (Exception e){
            System.out.println(e);
            return false;
        }
    }
//    发起添加好友请求
    @ResponseBody
    @RequestMapping(value = "/requestMaker",method = RequestMethod.POST)
    public String requestMaker(int reciver,int sponsor){
        try {
            if(reciver != sponsor){
                FriendList friendList = new FriendList(0,reciver,sponsor);
                flService.deleteRequest(friendList);
                flService.requestMaker(friendList);
                return "发送请求成功";
            }
            else return "不能添加自己！";
        } catch (Exception e){
            System.out.println(e);
            return "出错了";
        }
    }
//    删除好友请求
    @ResponseBody
    @RequestMapping(value = "/deleteRequest",method = RequestMethod.DELETE)
    public String deleteRequest(int reciver,int sponsor){
        try {
            if(reciver != sponsor){
                FriendList friendList = new FriendList(0,reciver,sponsor);
                flService.deleteRequest(friendList);
                friendList = new FriendList(0,sponsor,reciver);
                flService.deleteRequest(friendList);
                return "成功";
            }
            else return "不能删除！";
        } catch (Exception e){
            System.out.println(e);
            return "出错了";
        }
    }
//    获取一个人的好友请求
    @ResponseBody
    @RequestMapping(value = "/getRequest",method = RequestMethod.GET)
    public List<RequestList> getRequest(int user_id){
        return flService.getRequest(user_id);
    }


//    //  测试网页
//    @RequestMapping("/test")
//    public String showtest() {
//        return "test";
//    }
//    显示页面
    @RequestMapping("/friendList")
    public String show() {

        return "/friendList.html";
    }
    @RequestMapping("/friendRequest")
    public String showfriendRequest() {

        return "/friendRequest.html";
    }

    @RequestMapping("/findUnknownFriend/{userid}")
    @ResponseBody
    public User[] findUnknownFriend(@PathVariable("userid") long id) {
        return flService.findUnknownFriend(id);
    }

}
