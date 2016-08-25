package com.dnk.smart.door.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * relate:credential
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Lock {

    private long id;

    private long gatewayId;

    private long houseId;

    private String uuid;// 自动增长

    private String name;

    private String password;// 主密码,出厂设置

    private int device;// 设备号

    private Date createTime;

    private Date updateTime;

}
