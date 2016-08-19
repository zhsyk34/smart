package com.dnk.smart.door.dao;

import com.dnk.smart.door.entity.Unit;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UnitDao extends CommonsDao<Unit> {

    List<Unit> findList(@Param("buildId") Long buildId, @Param("name") String name, @Param("code") Long code, @Param("offset") int offset, @Param("limit") int limit);

    List<Map<String, Object>> findMap(@Param("build") String build, @Param("unit") String unit, @Param("code") Long code, @Param("offset") int offset, @Param("limit") int limit);

    int countMap(@Param("build") String build, @Param("unit") String unit, @Param("code") Long code);

}
