package com.dnk.smart.door.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Tenant {

    private long id;

    private long houseId;

    private String name;

    private String idCard;

    private String phone;

    private String gender;

    private String email;

    private boolean used;

    private Date createTime;

    private Date updateTime;

}
