package com.dnk.smart.door.service;

import com.dnk.smart.door.entity.Status;

import java.util.List;
import java.util.Map;

public interface StatusService {

    int save(Status status);

    int update(Status status);

    List<Map<String, Object>> findList(Long buildId, Long unitId, Long gatewayId, int pageNo, int pageSize);

    int count(Long buildId, Long unitId, Long gatewayId);

    List<Map<Long, List<Status>>> findList(Long unitId, Long gatewayId);

}
