package com.dnk.smart.door.service;

import com.dnk.smart.door.entity.Tenant;

import java.util.List;
import java.util.Map;

public interface TenantService {

    int save(Tenant tenant);

    int update(Tenant tenant);

    int delete(long[] ids);

    List<Tenant> findList(Long houseId, String name, String idCard, String gender, String phone, int pageNo, int pageSize);

    List<Map<String, Object>> findList(String build, String unit, String house, String name, String idCard, String gender, String phone, int pageNo, int pageSize);

    int count(String build, String unit, String house, String name, String idCard, String gender, String phone);

}
