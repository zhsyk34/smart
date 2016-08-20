package com.dnk.smart.door.dao;

import com.dnk.smart.door.entity.Credential;
import com.dnk.smart.door.entity.dict.CredentialType;
import com.dnk.smart.door.util.JSONParse;
import org.junit.Test;

import javax.annotation.Resource;

public class CredentialDaoTest extends InitTest {

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Resource
    private CredentialDao credentialDao;

    @Test
    public void save() {
        Credential credential = new Credential(0L, 1, "xx", CredentialType.FINGERPRINT, 3, null, null);
        credentialDao.save(credential);
    }

    @Test
    public void find() {
        credentialDao.findList(null, null, CredentialType.FINGERPRINT).forEach(JSONParse::toJSON);
    }
}