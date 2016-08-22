package com.dnk.smart.door.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Tenant {

    private long id;

    private long houseId;

    private String name;

    private String idCard;

    private String phone;

    private String gender;//TODO

    private String email;

    private boolean used;

    private Date createTime;

    private Date updateTime;

}
