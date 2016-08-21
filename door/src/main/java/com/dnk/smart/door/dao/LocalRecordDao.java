package com.dnk.smart.door.dao;

import com.dnk.smart.door.entity.LocalRecord;
import com.dnk.smart.door.entity.dict.Action;
import com.dnk.smart.door.entity.dict.ActionType;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface LocalRecordDao extends CommonsDao<LocalRecord> {

    List<LocalRecord> findList(@Param("uuid") String uuid, @Param("action") Action action, @Param("type") ActionType type, @Param("pass") Integer pass);

    List<Map<String, Object>> findMap(@Param("uuid") String uuid, @Param("action") Action action, @Param("type") ActionType type, @Param("pass") Integer pass, @Param("offset") int offset, @Param("limit") int limit);

    int countMap(@Param("uuid") String uuid, @Param("action") Action action, @Param("type") ActionType type, @Param("pass") Integer pass);
}
