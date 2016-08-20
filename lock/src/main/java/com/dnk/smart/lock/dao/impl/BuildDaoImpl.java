package com.dnk.smart.lock.dao.impl;

import com.dnk.smart.lock.dao.BaseDao;
import com.dnk.smart.lock.dao.BuildDao;
import com.dnk.smart.lock.entity.Build;
import org.springframework.stereotype.Repository;

@Repository
public class BuildDaoImpl extends BaseDao<Build, Long> implements BuildDao {

    @Override
    public int save(Build build) {
        return super.save(build);
    }

    @Override
    public int delete(long id) {
        return super.deleteById(id);
    }
}
