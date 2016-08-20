package com.dnk.smart.lock.dao;

import com.dnk.smart.lock.kit.ReflectUtil;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import static com.dnk.smart.lock.constant.Mapping.*;

public class BaseDao<Entity, PrimaryKey> extends SqlSessionDaoSupport {

    @Resource
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    protected String getEntityName() {
        Class<Entity> clazz = ReflectUtil.getClassGenericType(this.getClass());
        return clazz.getSimpleName();
    }

    /**
     * 需将xml中的命名空间改为XxxDao形式
     */
    protected String getSqlName(String sqlId) {
        System.out.println(getEntityName());
        return getEntityName() + DAO_SUFFIX + SQL_SEPARATOR + sqlId;
    }

    public int save(Entity entity) {
        return this.getSqlSession().insert(getSqlName(SQL_SAVE), entity);
    }

    public int saves(Collection<Entity> entities) {
        return this.getSqlSession().insert(getSqlName(SQL_SAVES), entities);
    }

    public int deleteById(PrimaryKey primayKey) {
        return this.getSqlSession().delete(getSqlName(SQL_DELETEBYID), primayKey);
    }

    public int deleteByEntity(Entity entity) {
        return this.getSqlSession().delete(getSqlName(SQL_DELETEBYENTITY), entity);
    }

    public int deleteByIds(PrimaryKey[] primayKeys) {
        return this.getSqlSession().delete(getSqlName(SQL_DELETEBYIDS), primayKeys);
    }

    public int deleteByEntities(Collection<Entity> entities) {
        return this.getSqlSession().delete(getSqlName(SQL_DELETEBYENTITIES), entities);
    }

    public int update(Entity entity) {
        return this.getSqlSession().update(getSqlName(SQL_UPDATE), entity);
    }

    public int updates(Entity entities) {
        return this.getSqlSession().update(getSqlName(SQL_UPDATES), entities);
    }

    public Entity findById(PrimaryKey primayKey) {
        return this.getSqlSession().selectOne(getSqlName(SQL_FINDBYID), primayKey);
    }

    public List<Entity> findAll() {
        return this.getSqlSession().selectList(getSqlName(SQL_FINDALL));
    }

    public List<Entity> findList(Map<String, Object> map) {
        return this.getSqlSession().selectList(getSqlName(SQL_FINDLIST), map);
    }

    public int count(Map<String, Object> map) {
        return this.getSqlSession().selectOne(getSqlName(SQL_COUNT), map);
    }

    public List<Map<String, Object>> findList(String methodName, Map<String, Object> map) {
        return this.getSqlSession().selectList(getSqlName(methodName), map);
    }

}
