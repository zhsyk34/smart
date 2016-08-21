package com.dnk.smart.door.dao;

import com.dnk.smart.door.entity.Status;

public interface StatusDao extends CommonsDao<Status> {
    Status find(String uuid);
}
