package com.example.demo.bean;

import java.util.Arrays;
import java.util.Date;

public class BlogInfo {

    private long ID;
    private long userId;
    private String tag;
    private String title;
    private String description;
    private long commentNum;
    private Date date;
    private long views;
    private long agreeNum;
    private int draft;
    private int up;
    private String keyword;

    public BlogInfo(long ID, long userId, String tag, String title, String description, long commentNum, Date date, long views, long agreeNum, int draft, int up, String keyword) {
        this.ID = ID;
        this.userId = userId;
        this.tag = tag;
        this.title = title;
        this.description = description;
        this.commentNum = commentNum;
        this.date = date;
        this.views = views;
        this.agreeNum = agreeNum;
        this.draft = draft;
        this.up = up;
        this.keyword = keyword;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(long commentNum) {
        this.commentNum = commentNum;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public long getViews() {
        return views;
    }

    public void setViews(long views) {
        this.views = views;
    }

    public long getAgreeNum() {
        return agreeNum;
    }

    public void setAgreeNum(long agreeNum) {
        this.agreeNum = agreeNum;
    }

    public int getDraft() {
        return draft;
    }

    public void setDraft(int draft) {
        this.draft = draft;
    }

    public int getUp() {
        return up;
    }

    public void setUp(int up) {
        this.up = up;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}