package com.example.demo.mapper;

import com.example.demo.bean.FriendList;
import com.example.demo.bean.RequestList;
import com.example.demo.bean.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface FriendListMapper {
//    查询某一用户的所有好友，返回list
    @Select("select * from friendlist where user_id=#{user_id}")
    public List<FriendList> getOnesTotalFriends(int user_id);
//    添加好友
    @Insert("insert into friendlist values(#{id},#{user_id},#{friend_id})")
    public  int newFriendship(FriendList friendList);
//    删除好友
    @Delete("delete from friendlist where user_id=#{user_id} and friend_id=#{friend_id}")
    public  int deleteFriendship(FriendList friendList);
//    获取好友状态
    @Select("select status from User_info where User_ID=#{friend_id}")
    public String getFriendStatus(int friend_id);

//    查询某一用户的好友请求
    @Select("select * from friend_request where reciver=#{user_id}")
    public List<RequestList> getRequest(int user_id);
//    发出添加好友请求
    @Insert("insert into friend_request values(#{id},#{user_id},#{friend_id})")
    public  int requestMaker(FriendList friendList);
//    请求完成（接受or拒绝）
    @Delete("delete from friend_request where reciver=#{user_id} and sponsor_id=#{friend_id}")
    public  int deleteRequest(FriendList friendList);

    @Select("select * from user_info where User_ID not in (select friend_id from friendlist where user_id = #{id}) and User_ID != #{id}")
    public User[] findUnknownFriend(long id);

}
