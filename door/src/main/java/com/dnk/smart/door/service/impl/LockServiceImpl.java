package com.dnk.smart.door.service.impl;

import com.dnk.smart.door.dao.LockDao;
import com.dnk.smart.door.entity.Lock;
import com.dnk.smart.door.service.LockService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class LockServiceImpl implements LockService {

    @Resource
    private LockDao lockDao;

    @Override
    public int save(Lock lock) {
        return lockDao.save(lock);
    }

    @Override
    public int update(Lock lock) {
        return lockDao.update(lock);
    }

    @Override
    public int delete(long[] ids) {
        return lockDao.deleteByIds(ids);
    }

    @Override
    public Lock find(long houseId) {
        List<Lock> list = lockDao.findList(null, houseId, null, null, -1, -1);
        return CollectionUtils.isEmpty(list) ? null : list.get(0);
    }

    @Override
    public Lock find(String uuid) {
        List<Lock> list = lockDao.findList(null, null, uuid, null, -1, -1);
        return CollectionUtils.isEmpty(list) ? null : list.get(0);
    }

    @Override
    public List<Lock> findList(Long gatewayId, Long houseId, String uuid, String name, int pageNo, int pageSize) {
        return lockDao.findList(gatewayId, houseId, uuid, name, (pageNo - 1) * pageSize, pageSize);
    }

    @Override
    public List<Map<String, Object>> findList(String build, String unit, String house, String name, int pageNo, int pageSize) {
        return lockDao.findMap(build, unit, house, name, (pageNo - 1) * pageSize, pageSize);
    }

    @Override
    public int count(String build, String unit, String house, String name) {
        return lockDao.countMap(build, unit, house, name);
    }

    @Override
    public boolean relate(long id) {
        // TODO
        return false;
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

    @Override
    public int findMinDevice(long gatewayId) {
        List<Integer> list = lockDao.findDevice(gatewayId);

        // 可用设备号0-99
        for (int i = 0; i < 100; i++) {
            if (!list.contains(i)) {
                return i;
            }
        }
        // 设备号已全部被使用
        return -1;
    }
}
