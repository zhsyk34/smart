package com.dnk.smart.door.service.impl;

import com.dnk.smart.door.dao.LockDao;
import com.dnk.smart.door.dao.StatusDao;
import com.dnk.smart.door.entity.Lock;
import com.dnk.smart.door.entity.Status;
import com.dnk.smart.door.service.StatusService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StatusServiceImpl implements StatusService {

    @Resource
    private StatusDao statusDao;
    @Resource
    private LockDao lockDao;

    @Override
    public int save(Status status) {
        return statusDao.save(status);
    }

    @Override
    public int update(Status status) {
        return statusDao.update(status);
    }

    @Override
    public List<Status> findList(int pageNo, int pageSize) {
        return statusDao.findInterval((pageNo - 1) * pageSize, pageSize);
    }

    @Override
    public Status find(long lockId) {
        Lock lock = lockDao.findById(lockId);
        return lock == null ? null : statusDao.find(lock.getUuid());
    }

}
