package com.example.demo.service;

import com.example.demo.bean.User;

public interface RegisterService {
    public int insertNewClient(User user);

    public int findUserIDByName(String userName);
}
