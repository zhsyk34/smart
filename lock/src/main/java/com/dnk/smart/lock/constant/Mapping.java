package com.dnk.smart.lock.constant;

public class Mapping {

    /**
     * entity->sql.xml->namespace
     */
    public static final String DAO_SUFFIX = "Dao";
    public static final String SQL_SEPARATOR = ".";

    /**
     * sql.xml id name standard
     */
    // save
    public static final String SQL_SAVE = "save";
    public static final String SQL_SAVES = "saves";
    // delete
    public static final String SQL_DELETEBYID = "deleteById";
    public static final String SQL_DELETEBYENTITY = "deleteByEntity";
    public static final String SQL_DELETEBYIDS = "deleteByIds";
    public static final String SQL_DELETEBYENTITIES = "deleteByEntities";
    // update
    public static final String SQL_UPDATE = "update";
    public static final String SQL_UPDATES = "updates";
    // find
    public static final String SQL_FINDBYID = "findById";
    public static final String SQL_FINDALL = "findAll";
    public static final String SQL_FINDLIST = "findList";
    public static final String SQL_COUNT = "count";

    /**
     * 各模块新增,如优化联表查询等...
     */
    public static final String s = "";
}
