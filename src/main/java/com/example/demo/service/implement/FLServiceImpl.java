package com.example.demo.service.implement;

import com.example.demo.bean.FriendList;
import com.example.demo.bean.RequestList;
import com.example.demo.bean.User;
import com.example.demo.mapper.FriendListMapper;
import com.example.demo.service.FLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FLServiceImpl implements FLService {

    @Autowired
    private FriendListMapper friendListMapper;
//  获取某个人全部好友
    @Override
    public List<FriendList> getOnesTotalFriends(int user_id) {

        return friendListMapper.getOnesTotalFriends(user_id);
    }
//    添加好友
    @Override
    public void newFriendShip(FriendList friendList) {
        friendListMapper.newFriendship(friendList);
    }
//    删除好友
    @Override
    public void deleteFriendShip(FriendList friendList) {
        friendListMapper.deleteFriendship(friendList);
    }

    @Override
    public String getFriendStatus(int friend_id) {
        return friendListMapper.getFriendStatus(friend_id);
    }

    @Override
    public List<RequestList> getRequest(int user_id) {
        return friendListMapper.getRequest(user_id);
    }

    @Override
    public void requestMaker(FriendList friendList) {
        friendListMapper.requestMaker(friendList);
    }

    @Override
    public void deleteRequest(FriendList friendList) {
        friendListMapper.deleteRequest(friendList);
    }

    @Override
    public User[] findUnknownFriend(long id) {
        return friendListMapper.findUnknownFriend(id);
    }
}
