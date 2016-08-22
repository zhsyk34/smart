package com.dnk.smart.door.dao;

import com.dnk.smart.door.entity.LocalRecord;
import com.dnk.smart.door.entity.dict.Action;
import com.dnk.smart.door.entity.dict.ActionType;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface LocalRecordDao extends CommonsDao<LocalRecord> {

    List<Map<String, Object>> findMap(@Param("build") String build, @Param("unit") String unit, @Param("house") String house, @Param("lock") String lock, @Param("action") Action action, @Param("type") ActionType type, @Param("offset") int offset, @Param("limit") int limit);

    int countMap(@Param("build") String build, @Param("unit") String unit, @Param("house") String house, @Param("lock") String lock, @Param("action") Action action, @Param("type") ActionType type);
}