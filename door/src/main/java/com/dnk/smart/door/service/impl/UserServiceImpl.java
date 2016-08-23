package com.dnk.smart.door.service.impl;

import com.dnk.smart.door.dao.UserDao;
import com.dnk.smart.door.entity.User;
import com.dnk.smart.door.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    public User login(String name, String password) {
        return userDao.find(name, password);
    }
}
