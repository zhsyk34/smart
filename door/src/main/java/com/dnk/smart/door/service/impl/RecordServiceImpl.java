package com.dnk.smart.door.service.impl;

import com.dnk.smart.door.dao.LocalRecordDao;
import com.dnk.smart.door.dao.RecordDao;
import com.dnk.smart.door.entity.dict.RecordType;
import com.dnk.smart.door.service.RecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class RecordServiceImpl implements RecordService {

    @Resource
    private RecordDao recordDao;
    @Resource
    private LocalRecordDao localRecordDao;

    @Override
    public List<Map<String, Object>> findList(RecordType from, String build, String unit, String house, String lock, int pageNo, int pageSize) {
        if (from == null) {
            //TODO
            from = RecordType.CLOUD;
        }
        switch (from) {
            case CLOUD:
                return recordDao.findMap(build, unit, house, lock, null, null, (pageNo - 1) * pageSize, pageSize);
            case LOCAL:
                return localRecordDao.findMap(build, unit, house, lock, null, null, (pageNo - 1) * pageSize, pageSize);
            default:
                return null;
        }
    }

    @Override
    public int count(RecordType from, String build, String unit, String house, String lock) {
        if (from == null) {
            //TODO
            from = RecordType.CLOUD;
        }
        switch (from) {
            case CLOUD:
                return recordDao.countMap(build, unit, house, lock, null, null);
            case LOCAL:
                return localRecordDao.countMap(build, unit, house, lock, null, null);
            default:
                return 0;
        }
    }
}
