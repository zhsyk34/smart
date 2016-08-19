package com.dnk.smart.door.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class User {

    private long id;

    private String name;

    private String password;

    private Date createTime;

    private Date updateTime;

}
