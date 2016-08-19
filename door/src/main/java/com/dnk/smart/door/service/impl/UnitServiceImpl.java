package com.dnk.smart.door.service.impl;

import com.dnk.smart.door.dao.GatewayDao;
import com.dnk.smart.door.dao.HouseDao;
import com.dnk.smart.door.dao.UnitDao;
import com.dnk.smart.door.entity.Gateway;
import com.dnk.smart.door.entity.House;
import com.dnk.smart.door.entity.Unit;
import com.dnk.smart.door.service.UnitService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class UnitServiceImpl implements UnitService {

    @Resource
    private UnitDao unitDao;
    @Resource
    private HouseDao houseDao;
    @Resource
    private GatewayDao gatewayDao;

    @Override
    public int save(Unit unit) {
        return unitDao.save(unit);
    }

    @Override
    public int update(Unit unit) {
        return unitDao.update(unit);
    }

    @Override
    public int delete(long[] ids) {
        return unitDao.deleteByIds(ids);
    }

    @Override
    public Unit find(long code) {
        List<Unit> list = unitDao.findList(null, null, code, -1, -1);
        return CollectionUtils.isEmpty(list) ? null : list.get(0);
    }

    @Override
    public List<Unit> findList(Long buildId, String name, int pageNo, int pageSize) {
        return unitDao.findList(buildId, name, null, (pageNo - 1) * pageSize, pageSize);
    }

    @Override
    public List<Map<String, Object>> findList(String build, String unit, int pageNo, int pageSize) {
        return unitDao.findMap(build, unit, null, (pageNo - 1) * pageSize, pageSize);
    }

    @Override
    public int count(String build, String unit) {
        return unitDao.countMap(build, unit, null);
    }

    @Override
    public boolean exist(long id, long code) {
        Unit unit = this.find(code);
        return unit != null && unit.getId() != id;
    }

    @Override
    public boolean relate(long id) {
        List<House> houses = houseDao.findList(id, null, null, -1, -1);
        if (!CollectionUtils.isEmpty(houses)) {
            return true;
        }
        List<Gateway> gateways = gatewayDao.findList(id, null, null, -1, -1);
        return !CollectionUtils.isEmpty(gateways);
    }

    @Override
    public boolean relate(long[] ids) {
        for (long id : ids) {
            if (this.relate(id)) {
                return true;
            }
        }
        return false;
    }
}
