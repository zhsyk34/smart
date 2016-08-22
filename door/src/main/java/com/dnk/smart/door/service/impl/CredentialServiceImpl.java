package com.dnk.smart.door.service.impl;

import com.dnk.smart.door.dao.CredentialDao;
import com.dnk.smart.door.entity.Credential;
import com.dnk.smart.door.entity.dict.CredentialType;
import com.dnk.smart.door.service.CredentialService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CredentialServiceImpl implements CredentialService {

    @Resource
    private CredentialDao credentialDao;

    @Override
    public int save(Credential credential) {
        return credentialDao.save(credential);
    }

    @Override
    public int update(Credential credential) {
        return credentialDao.update(credential);
    }

    @Override
    public Credential find(String uuid, CredentialType type, int sequence) {
        List<Credential> list = credentialDao.findList(null, uuid, type, sequence);
        return CollectionUtils.isEmpty(list) ? null : list.get(0);
    }
}
