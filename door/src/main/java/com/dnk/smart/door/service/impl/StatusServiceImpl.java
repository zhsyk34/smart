package com.dnk.smart.door.service.impl;

import com.dnk.smart.door.dao.GatewayDao;
import com.dnk.smart.door.dao.StatusDao;
import com.dnk.smart.door.entity.Gateway;
import com.dnk.smart.door.entity.Status;
import com.dnk.smart.door.service.StatusService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StatusServiceImpl implements StatusService {

    @Resource
    private StatusDao statusDao;
    @Resource
    private GatewayDao gatewayDao;

    @Override
    public int save(Status status) {
        return statusDao.save(status);
    }

    @Override
    public int update(Status status) {
        return statusDao.update(status);
    }

    @Override
    public List<Map<String, Object>> findList(Long buildId, Long unitId, Long gatewayId, int pageNo, int pageSize) {
        return statusDao.findMap(buildId, unitId, gatewayId, (pageNo - 1) * pageSize, pageSize);
    }

    @Override
    public int count(Long buildId, Long unitId, Long gatewayId) {
        return statusDao.countMap(buildId, unitId, gatewayId);
    }

    @Override
    public List<Map<Long, List<Status>>> findList(Long unitId, Long gatewayId) {
        List<Gateway> gateways;
        if (gatewayId != null && gatewayId > 0) {
            gateways = new ArrayList<>();
            gateways.add(gatewayDao.findById(gatewayId));
        } else {
            gateways = gatewayDao.findList(unitId, null, null, -1, -1);
        }

        if (CollectionUtils.isEmpty(gateways)) {
            return null;
        }

        List<Map<Long, List<Status>>> list = new ArrayList<>();
        gateways.forEach(gateway -> {
            List<Status> statuses = statusDao.findList(gateway.getUnitId());

            if (!CollectionUtils.isEmpty(statuses)) {
                Map<Long, List<Status>> map = new HashMap<>();

                map.put(gateway.getId(), statuses);
                list.add(map);
            }
        });

        return list;
    }

    @Override
    public List<Map<String, List<Map<String, Object>>>> findVOList(Long unitId, Long gatewayId) {
        List<Gateway> gateways;
        if (gatewayId != null && gatewayId > 0) {
            gateways = new ArrayList<>();
            gateways.add(gatewayDao.findById(gatewayId));
        } else {
            gateways = gatewayDao.findList(unitId, null, null, -1, -1);
        }

        if (CollectionUtils.isEmpty(gateways)) {
            return null;
        }

        List<Map<String, List<Map<String, Object>>>> list = new ArrayList<>();
        gateways.forEach(gateway -> {
            List<Map<String, Object>> maps = statusDao.findMap(null, gateway.getUnitId(), null, -1, -1);

            if (!CollectionUtils.isEmpty(maps)) {
                Map<String, List<Map<String, Object>>> map = new HashMap<>();

                map.put(gateway.getName(), maps);
                list.add(map);
            }
        });
        return list;
    }

}
