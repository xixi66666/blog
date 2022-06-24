package com.example.demo.service;

import com.example.demo.bean.User;

public interface AlterInfoService
{
    public int AlterInfo(User user);

    public void resetPassword(User user);
}
