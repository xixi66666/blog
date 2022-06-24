package com.example.demo.service.implement;

import com.example.demo.bean.BlogInfo;
import com.example.demo.mapper.PersonMainPageMapper;
import com.example.demo.service.PMPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PMPageServiceImpl implements PMPageService {
    @Autowired
    private PersonMainPageMapper personMainPageMapper;


    @Override
    public List<BlogInfo> getOnesTotalBlogs(int user_id){
        return personMainPageMapper.getOnesTotalBlogs(user_id);
    }
}
