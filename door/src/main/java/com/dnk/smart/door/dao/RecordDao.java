package com.dnk.smart.door.dao;

import com.dnk.smart.door.entity.Record;
import com.dnk.smart.door.entity.dict.Action;
import com.dnk.smart.door.entity.dict.ActionType;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface RecordDao extends CommonsDao<Record> {

    @Deprecated
    List<Record> findList(@Param("uuid") String uuid, @Param("action") Action action, @Param("type") ActionType type, @Param("pass") Integer pass, @Param("offset") int offset, @Param("limit") int limit);

    List<Map<String, Object>> findMap(@Param("build") String build, @Param("unit") String unit, @Param("house") String house, @Param("lock") String lock, @Param("action") Action action, @Param("type") ActionType type, @Param("offset") int offset, @Param("limit") int limit);

    int countMap(@Param("build") String build, @Param("unit") String unit, @Param("house") String house, @Param("lock") String lock, @Param("action") Action action, @Param("type") ActionType type);
}
