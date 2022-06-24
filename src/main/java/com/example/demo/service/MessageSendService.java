package com.example.demo.service;

import com.example.demo.bean.Message;

public interface MessageSendService {
    public int showData();

    public int insertMessageRecord(Message message);

    public long findUserIDByName(String userName);

    public String[] findUnreceivedRecord(long receiver);

    public Message[] findRelatedRecord(long userid1, long userid2);
}
