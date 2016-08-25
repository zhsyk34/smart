package com.dnk.smart.door.entity;

import com.dnk.smart.door.entity.dict.CredentialType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * 凭据:密码或指纹等,同一用户tenantId在某设备lockId上只能有唯一的凭据?
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Credential {

    private long id;

    private long tenantId;

    private long lockId;

    private CredentialType type;

    private String value;

    private int sequence;// 1:主密码,99:临时密码,用户密码:2-98

    private Date createTime;

    private Date updateTime;

}
