package com.dnk.smart.door.service;

import com.dnk.smart.door.entity.Unit;

import java.util.List;
import java.util.Map;

public interface UnitService {

    int save(Unit unit);

    int update(Unit unit);

    int delete(long[] ids);

    Unit find(long code);

    List<Unit> findList(Long buildId, String name, int pageNo, int pageSize);

    List<Map<String, Object>> findList(String build, String unit, int pageNo, int pageSize);

    int count(String build, String unit);

    boolean exist(long id, long code);

    boolean relate(long id);

    boolean relate(long[] ids);
}
