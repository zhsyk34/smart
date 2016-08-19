package com.dnk.smart.door.service.impl;

import com.dnk.smart.door.dao.GatewayDao;
import com.dnk.smart.door.dao.HouseDao;
import com.dnk.smart.door.dao.LockDao;
import com.dnk.smart.door.dao.TenantDao;
import com.dnk.smart.door.entity.House;
import com.dnk.smart.door.entity.Lock;
import com.dnk.smart.door.entity.Tenant;
import com.dnk.smart.door.service.HouseService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class HouseServiceImpl implements HouseService {

    @Resource
    private HouseDao houseDao;
    @Resource
    private GatewayDao gatewayDao;
    @Resource
    private LockDao lockDao;
    @Resource
    private TenantDao tenantDao;

    @Override
    public int save(House house) {
        return houseDao.save(house);
    }

    @Override
    public int update(House house) {
        return houseDao.update(house);
    }

    @Override
    public int delete(long[] ids) {
        return houseDao.deleteByIds(ids);
    }

    @Override
    public House find(long code) {
        List<House> list = houseDao.findList(null, null, code, -1, -1);
        return CollectionUtils.isEmpty(list) ? null : list.get(0);
    }

    @Override
    public List<House> findList(Long unitId, String name, int pageNo, int pageSize) {
        return houseDao.findList(unitId, name, null, (pageNo - 1) * pageSize, pageSize);
    }

    @Override
    public List<Map<String, Object>> findList(String build, String unit, String house, int pageNo, int pageSize) {
        return houseDao.findMap(build, unit, house, null, (pageNo - 1) * pageSize, pageSize);
    }

    @Override
    public int count(String build, String unit, String house) {
        return houseDao.countMap(build, unit, house, null);
    }

    @Override
    public boolean exist(long id, long code) {
        House house = this.find(code);
        return house != null && house.getId() != id;
    }

    @Override
    public boolean relate(long id) {
        List<Lock> locks = lockDao.findList(null, id, null, null, -1, -1);
        if (!CollectionUtils.isEmpty(locks)) {
            return true;
        }
        List<Tenant> tenants = tenantDao.findList(id, null, null, null, null, -1, -1);
        return !CollectionUtils.isEmpty(tenants);
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

    // @Override
    // public List<House> findListByGateway(long gatewayId) {
    // Gateway gateway = gatewayDao.findById(gatewayId);
    // return gateway == null ? null : houseDao.findList(gateway.getUnitId(),
    // null, null, -1, -1);
    // }
}
