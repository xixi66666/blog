package com.example.demo.service.implement;

import com.example.demo.bean.User;
import com.example.demo.mapper.UserSearchMapper;
import com.example.demo.service.USService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class USServiceImpl implements USService {
    @Autowired
    private UserSearchMapper userSearchMapper;

    @Override
    public User userSearch(int User_ID){
//        实现搜索
        System.out.println(User_ID);
        System.out.println(userSearchMapper.getByUID(User_ID));
        return userSearchMapper.getByUID(User_ID);
    }
}
