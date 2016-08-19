package com.dnk.smart.door.dao;

import com.dnk.smart.door.entity.Tenant;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface TenantDao extends CommonsDao<Tenant> {

    List<Tenant> findList(@Param("houseId") Long houseId, @Param("name") String name, @Param("idCard") String idCard, @Param("gender") String gender, @Param("phone") String phone, @Param("offset") int offset, @Param("limit") int limit);

    List<Map<String, Object>> findMap(@Param("build") String build, @Param("unit") String unit, @Param("house") String house, @Param("name") String name, @Param("idCard") String idCard, @Param("gender") String gender, @Param("phone") String phone, @Param("offset") int offset, @Param("limit") int limit);

    int countMap(@Param("build") String build, @Param("unit") String unit, @Param("house") String house, @Param("name") String name, @Param("idCard") String idCard, @Param("gender") String gender, @Param("phone") String phone);
}
