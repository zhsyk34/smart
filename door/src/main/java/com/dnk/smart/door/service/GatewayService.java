package com.dnk.smart.door.service;

import com.dnk.smart.door.entity.Gateway;

import java.util.List;
import java.util.Map;

public interface GatewayService {

    int save(Gateway gateway);

    int update(Gateway gateway);

    int delete(long[] ids);

    Gateway find(String udid);

    List<Gateway> findList(long unitId);

    List<Gateway> findList(Long unitId, String udid, String name, int pageNo, int pageSize);

    List<Map<String, Object>> findList(String build, String unit, String name, int pageNo, int pageSize);

    int count(String build, String unit, String name);

    boolean relate(long id);

    boolean relate(long[] ids);
}
