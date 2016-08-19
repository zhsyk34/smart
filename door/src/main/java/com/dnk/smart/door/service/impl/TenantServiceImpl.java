package com.dnk.smart.door.service.impl;

import com.dnk.smart.door.dao.TenantDao;
import com.dnk.smart.door.entity.Tenant;
import com.dnk.smart.door.service.TenantService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class TenantServiceImpl implements TenantService {

    @Resource
    private TenantDao tenantDao;

    @Override
    public int save(Tenant tenant) {
        return tenantDao.save(tenant);
    }

    @Override
    public int update(Tenant tenant) {
        return tenantDao.update(tenant);
    }

    @Override
    public int delete(long[] ids) {
        return tenantDao.deleteByIds(ids);
    }

    @Override
    public List<Tenant> findList(Long houseId, String name, String idCard, String gender, String phone, int pageNo, int pageSize) {
        return tenantDao.findList(houseId, name, idCard, gender, phone, (pageNo - 1) * pageSize, pageSize);
    }

    @Override
    public List<Map<String, Object>> findList(String build, String unit, String house, String name, String idCard, String gender, String phone, int pageNo, int pageSize) {
        return tenantDao.findMap(build, unit, house, name, idCard, gender, phone, (pageNo - 1) * pageSize, pageSize);
    }

    @Override
    public int count(String build, String unit, String house, String name, String idCard, String gender, String phone) {
        return tenantDao.countMap(build, unit, house, name, idCard, gender, phone);
    }

}
