package com.dnk.smart.door.dao;

import com.dnk.smart.door.entity.Record;
import com.dnk.smart.door.entity.dict.Action;
import com.dnk.smart.door.entity.dict.ActionType;
import com.dnk.smart.door.util.JSONParse;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RecordDaoTest extends InitTest {

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Resource
    private RecordDao recordDao;

    @Test
    public void save() throws Exception {
        List<Record> list = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            Record record = new Record(0L, "xyz", Action.OPEN, ActionType.BROKEN, i, "", new Date(), null);
            list.add(record);
        }
        recordDao.saves(list);
    }

    @Test
    public void update() throws Exception {
        List<Record> list = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            Record record = new Record(0L, "xyz", Action.OPEN, ActionType.BROKEN, i, "", new Date(), null);
            list.add(record);
        }
        recordDao.saves(list);
    }

    @Test
    public void findList() throws Exception {
        recordDao.findMap(null, null, null, null, null, null, -1, -1).forEach(JSONParse::toJSON);
    }

    @Test
    public void findMap() throws Exception {
    }

    @Test
    public void countMap() throws Exception {

    }

}