package com.dnk.smart.door.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Lock {

    private long id;

    private long gatewayId;

    private long houseId;

    private String uuid;// 自动增长

    private String name;

    private int area;// 区域号

    private int device;// 设备号

    private Date createTime;

    private Date updateTime;

}