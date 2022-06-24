package com.example.demo.service.implement;

import com.example.demo.bean.Message;
import com.example.demo.mapper.MessageSendMapper;
import com.example.demo.service.MessageSendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageSendServiceImpl implements MessageSendService {

    @Autowired
    MessageSendMapper messageSendMapper;

    @Override
    public int showData() {
        int res = messageSendMapper.getMessageRecordNumber();
        return res;
    }

    @Override
    public int insertMessageRecord(Message message) {
        messageSendMapper.insertMessageRecord(message);
        return 0;
    }

    @Override
    public long findUserIDByName(String userName) {
        return messageSendMapper.findUserIDByName(userName);
    }

    @Override
    public String[] findUnreceivedRecord(long receiver) {
        return messageSendMapper.findUnreceivedRecord(receiver);
    }

    @Override
    public Message[] findRelatedRecord(long userid1, long userid2) {
        return messageSendMapper.findRelatedRecord(userid1, userid2);
    }
}
