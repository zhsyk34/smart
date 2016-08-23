package com.dnk.smart.door.dao;

import com.dnk.smart.door.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserDao extends CommonsDao<User> {

    User find(@Param("name") String name, @Param("password") String password);
}
