package com.dnk.smart.door.entity;

import com.dnk.smart.door.entity.dict.CredentialType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * 凭据,密码或指纹等...
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Credential {

    private long id;

    private long tenantId;

    private String uuid;

    private CredentialType type;

    private int sequence;

    private Date createTime;

    private Date updateTime;

}
