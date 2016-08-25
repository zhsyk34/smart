package com.dnk.smart.door.dao;

import com.dnk.smart.door.entity.Credential;
import com.dnk.smart.door.entity.dict.CredentialType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CredentialDao extends CommonsDao<Credential> {

    List<Credential> findList(@Param("tenantId") Long tenantId, @Param("lockId") Long lockId, @Param("type") CredentialType type, @Param("sequence") Integer sequence);

    List<Integer> allot(@Param("lockId") long lockId, @Param("type") CredentialType type);

}
