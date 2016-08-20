package com.dnk.smart.door.dao;

import com.dnk.smart.door.util.JSONParse;
import org.junit.Test;

import javax.annotation.Resource;

public class LockDaoTest extends InitTest {

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Resource
    private LockDao lockDao;

    @Test
    public void findList() throws Exception {
        lockDao.findList(null, null, null, null, -1, -1).forEach(JSONParse::toJSON);
    }

    @Test
    public void findMap() throws Exception {

    }

    @Test
    public void countMap() throws Exception {

    }

    @Test
    public void findDevice() throws Exception {

    }

}