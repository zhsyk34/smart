package com.dnk.smart.door.service;

import com.dnk.smart.door.entity.Status;

import java.util.List;

public interface StatusService {

    int save(Status status);

    int update(Status status);

    List<Status> findList(int pageNo, int pageSize);

    Status find(long lockId);

}
