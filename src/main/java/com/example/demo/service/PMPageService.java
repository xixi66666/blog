package com.example.demo.service;

import com.example.demo.bean.BlogInfo;

import java.util.List;

public interface PMPageService {
    public List<BlogInfo> getOnesTotalBlogs(int user_id);
}
