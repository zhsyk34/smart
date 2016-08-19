package com.dnk.smart.door.service;

import com.dnk.smart.door.entity.Lock;

import java.util.List;
import java.util.Map;

public interface LockService {

    int save(Lock lock);

    int update(Lock lock);

    int delete(long[] ids);

    Lock find(long houseId);

    Lock find(String uuid);

    List<Lock> findList(Long gatewayId, Long houseId, String uuid, String name, int pageNo, int pageSize);

    List<Map<String, Object>> findList(String build, String unit, String house, String name, int pageNo, int pageSize);

    int count(String build, String unit, String house, String name);

    boolean relate(long id);

    boolean relate(long[] ids);

    int findMinDevice(long gatewayId);
}
