package com.dnk.smart.door.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class House {

    private long id;

    private long unitId;

    private String name;

    private long code;

    private Date createTime;

    private Date updateTime;

}
