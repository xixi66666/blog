package com.example.demo.service;

import com.example.demo.bean.FriendList;
import com.example.demo.bean.RequestList;
import com.example.demo.bean.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;

import java.util.List;

public interface FLService {
    public List<FriendList> getOnesTotalFriends(int user_id);
    public void newFriendShip(FriendList friendList);
    public void deleteFriendShip(FriendList friendList);
    public String getFriendStatus(int friend_id);

    public List<RequestList> getRequest(int user_id);
    public void requestMaker(FriendList friendList);
    public void deleteRequest(FriendList friendList);
    public User[] findUnknownFriend(long id);
}
