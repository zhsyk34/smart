package com.dnk.smart.door.dao;

import com.dnk.smart.door.entity.SessionInfo;
import org.apache.ibatis.annotations.Param;

public interface SessionInfoDao extends CommonsDao<SessionInfo> {

    SessionInfo find(@Param("udid") String udid);
}
