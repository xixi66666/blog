package com.example.demo.bean;

import java.sql.Timestamp;
import java.util.Arrays;

public class Message {

    private long messageid;
    private long sender;
    private long receiver;
    private String content;
    private byte[] image;
    private Timestamp date;
    private int isreceived;

    public Message(long messageid, long sender, long receiver, String content, byte[] image, Timestamp date, int isreceived) {
        this.messageid = messageid;
        this.sender = sender;
        this.receiver = receiver;
        this.content = content;
        this.image = image;
        this.date = date;
        this.isreceived = isreceived;
    }

    public long getMessageid() {
        return messageid;
    }

    public void setMessageid(long messageid) {
        this.messageid = messageid;
    }

    public long getSender() {
        return sender;
    }

    public void setSender(long sender) {
        this.sender = sender;
    }

    public long getReceiver() {
        return receiver;
    }

    public void setReceiver(long receiver) {
        this.receiver = receiver;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public int getIsreceived() {
        return isreceived;
    }

    public void setIsreceived(int isreceived) {
        this.isreceived = isreceived;
    }

    @Override
    public String toString() {
        return "Message{" +
                "messageid=" + messageid +
                ", sender=" + sender +
                ", receiver=" + receiver +
                ", content='" + content + '\'' +
                ", image=" + Arrays.toString(image) +
                ", date=" + date +
                ", isreceived=" + isreceived +
                '}';
    }
}
