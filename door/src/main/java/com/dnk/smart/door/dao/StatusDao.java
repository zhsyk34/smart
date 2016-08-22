package com.dnk.smart.door.dao;

import com.dnk.smart.door.entity.Status;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StatusDao extends CommonsDao<Status> {

    List<Status> findList(@Param("gatewayId") Long gatewayId);

    List<Map<String, Object>> findMap(@Param("buildId") Long buildId, @Param("unitId") Long unitId, @Param("gatewayId") Long gatewayId, @Param("offset") int offset, @Param("limit") int limit);

    int countMap(@Param("buildId") Long buildId, @Param("unitId") Long unitId, @Param("gatewayId") Long gatewayId);

}
