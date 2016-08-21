package com.dnk.smart.door.dao;

import org.junit.Test;

import javax.annotation.Resource;

public class InitData extends InitTest {

    @Resource
    private BuildDao buildDao;
    @Resource
    private UnitDao unitDao;
    @Resource
    private HouseDao houseDao;
    @Resource
    private GatewayDao gatewayDao;
    @Resource
    private LockDao lockDao;
    @Resource
    private TenantDao tenantDao;
    @Resource
    private RecordDao recordDao;
    @Resource
    private LocalRecordDao localRecordDao;
    @Resource
    private StatusDao statusDao;

    @Test
    public void init() {

    }
}
