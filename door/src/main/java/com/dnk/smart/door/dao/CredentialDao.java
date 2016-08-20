package com.dnk.smart.door.dao;

import com.dnk.smart.door.entity.Credential;
import com.dnk.smart.door.entity.dict.CredentialType;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

//TODO
public interface CredentialDao extends CommonsDao<Credential> {
    @Deprecated
    List<Credential> findList(@Param("tenantId") Long tenantId, @Param("uuid") String uuid, @Param("type") CredentialType type);

    @Deprecated
    List<Map<String, Object>> findMap(@Param("tenant") String tenant, @Param("house") String house, @Param("lock") String lock, @Param("type") CredentialType type, @Param("offset") int offset, @Param("limit") int limit);

    @Deprecated
    int countMap(@Param("tenant") String tenant, @Param("house") String house, @Param("lock") String lock, @Param("type") CredentialType type);
}
