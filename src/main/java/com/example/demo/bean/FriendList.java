package com.example.demo.bean;


import lombok.Data;

public class FriendList {

    private int id;
    private int user_id;
    private int friend_id;

    public FriendList() {
    }

    public FriendList(int id, int user_id, int friend_id) {
        this.id = id;
        this.user_id = user_id;
        this.friend_id = friend_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getFriend_id() {
        return friend_id;
    }

    public void setFriend_id(int friend_id) {
        this.friend_id = friend_id;
    }

    @Override
    public String toString() {
        return "FriendList{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", friend_id=" + friend_id +
                '}';
    }
}
