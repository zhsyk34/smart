package com.dnk.smart.lock.dao;

import com.dnk.smart.lock.entity.Build;

public interface BuildDao {

    int save(Build build);

    int delete(long id);

}
