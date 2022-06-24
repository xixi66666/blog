package com.example.demo.service.implement;

import com.example.demo.bean.User;
import com.example.demo.mapper.LoginMapper;
import com.example.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginMapper loginMapper;
    @Override
    public Integer LoginCheck(User user) {
        return loginMapper.checklogin(user);
    }
}
