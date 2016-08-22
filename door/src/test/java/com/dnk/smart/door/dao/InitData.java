package com.dnk.smart.door.dao;

import com.dnk.smart.door.entity.*;
import com.dnk.smart.door.entity.dict.Action;
import com.dnk.smart.door.entity.dict.ActionType;
import com.dnk.smart.door.entity.dict.CredentialType;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SuppressWarnings("SpringJavaAutowiringInspection")
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
    @Resource
    private CredentialDao credentialDao;

    @Test
    public void init6() {
        List<Status> statuses = new ArrayList<>();

        lockDao.findAll().forEach(lock -> {
            String uuid = lock.getUuid();
            Status status = new Status(0L, uuid, 1, 1, 1, 28, true, new Date());

            statuses.add(status);
        });

        statusDao.saves(statuses);

    }

    @Test
    public void init5() {
        List<Credential> credentials = new ArrayList<>();

        Lock lock = lockDao.findById(1);

        if (lock != null) {
            for (int j = 1; j < 5; j++) {
                Credential credential = new Credential(0L, 1, lock.getUuid(), CredentialType.PASSWORD, j, null, null);
                credentials.add(credential);
            }
        }

        credentialDao.saves(credentials);
    }

    @Test
    public void init4() {
        List<Record> records = new ArrayList<>();
        for (int t = 1; t < 6; t++) {
            Lock lock = lockDao.findById(t);
            Record record = new Record(0L, lock.getUuid(), Action.CLOSE, ActionType.BROKEN, t, "nothing", new Date(), null);

            records.add(record);
        }
        recordDao.saves(records);

        List<LocalRecord> localRecords = new ArrayList<>();
        for (int t = 1; t < 6; t++) {
            Lock lock = lockDao.findById(t);
            LocalRecord localRecord = new LocalRecord(0L, lock.getUuid(), Action.CLOSE, ActionType.BROKEN, t, "nothing", new Date(), null);

            localRecords.add(localRecord);
        }
        localRecordDao.saves(localRecords);
    }

    @Test
    public void init2() {

        List<Gateway> gateways = new ArrayList<>();
        List<Lock> locks = new ArrayList<>();

        for (int g = 1; g < 6; g++) {
            gateways.add(new Gateway(0L, g, "sn" + g, "ud" + g, "gateway" + g, "ip" + g, 7000 + g, "remote", "v" + g, null, null, null));
        }
        for (int l = 1; l < 6; l++) {
            locks.add(new Lock(0L, l, l, null, "lock" + l, 2 * l, 3 * l, null, null));
        }
        gatewayDao.saves(gateways);
        lockDao.saves(locks);

        //锁
        List<Tenant> tenants = new ArrayList<>();
        for (int t = 1; t < 6; t++) {
            tenants.add(new Tenant(0L, t, "tenant" + t, "3505" + t, "188188", "male", null, true, null, null));
        }
        tenantDao.saves(tenants);
    }

    @Test
    public void init() {

        List<Build> builds = new ArrayList<>();
        List<Unit> units = new ArrayList<>();
        List<House> houses = new ArrayList<>();

        for (int b = 1; b < 6; b++) {
            builds.add(new Build(0L, "build" + b, 100 + b, null, null));
        }
        for (int u = 1; u < 6; u++) {
            units.add(new Unit(0L, u, "unit" + u, 200 + u, null, null));
        }
        for (int h = 1; h < 6; h++) {
            houses.add(new House(0L, h, "house" + h, 300 + h, null, null));
        }
        buildDao.saves(builds);
        unitDao.saves(units);
        houseDao.saves(houses);
    }
}
