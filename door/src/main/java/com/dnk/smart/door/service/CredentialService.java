package com.dnk.smart.door.service;

import com.dnk.smart.door.entity.Credential;
import com.dnk.smart.door.entity.dict.CredentialType;

public interface CredentialService {

    int save(Credential credential);

    int update(Credential credential);

    Credential find(String uuid, CredentialType type, int sequence);
}
