package com.dnk.smart.door.service;

import com.dnk.smart.door.entity.User;

public interface UserService {

    User login(String name, String password);
}
