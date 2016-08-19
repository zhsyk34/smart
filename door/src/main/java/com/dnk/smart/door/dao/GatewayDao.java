package com.dnk.smart.door.dao;

import com.dnk.smart.door.entity.Gateway;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface GatewayDao extends CommonsDao<Gateway> {

    List<Gateway> findList(@Param("unitId") Long unitId, @Param("udid") String udid, @Param("name") String name, @Param("offset") int offset, @Param("limit") int limit);

    List<Map<String, Object>> findMap(@Param("build") String build, @Param("unit") String unit, @Param("name") String name, @Param("offset") int offset, @Param("limit") int limit);

    int countMap(@Param("build") String build, @Param("unit") String unit, @Param("name") String name);
}
