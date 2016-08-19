package com.dnk.smart.door.service;

import com.dnk.smart.door.entity.House;

import java.util.List;
import java.util.Map;

public interface HouseService {

    int save(House house);

    int update(House house);

    int delete(long[] ids);

    House find(long code);

    List<House> findList(Long unitId, String name, int pageNo, int pageSize);

    List<Map<String, Object>> findList(String build, String unit, String house, int pageNo, int pageSize);

    int count(String build, String unit, String house);

    boolean exist(long id, long code);

    boolean relate(long id);

    boolean relate(long[] ids);

    // List<House> findListByGateway(long gatewayId);
}
