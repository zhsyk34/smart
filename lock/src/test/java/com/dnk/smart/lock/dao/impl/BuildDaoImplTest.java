package com.dnk.smart.lock.dao.impl;

import com.dnk.smart.lock.dao.BuildDao;
import com.dnk.smart.lock.entity.Build;
import org.junit.Test;

import javax.annotation.Resource;

import static org.junit.Assert.*;

public class BuildDaoImplTest extends InitTest {

    @Resource
    private BuildDao buildDao;

    @Test
    public void save() throws Exception {
        Build build = new Build(0L, "build1", null, null);
        System.out.println(buildDao);
        buildDao.save(build);
    }

}