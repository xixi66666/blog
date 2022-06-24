package com.example.demo.service.implement;

import com.example.demo.bean.User;
import com.example.demo.mapper.RegisterMapper;
import com.example.demo.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl implements RegisterService
{
    @Autowired
    private RegisterMapper registerMapper;

    @Override
    public int insertNewClient(User user) {
        return registerMapper.insertNewClient(user);
    }

    @Override
    public int findUserIDByName(String userName) {
        return registerMapper.findUserIDByName(userName);
    }
}
