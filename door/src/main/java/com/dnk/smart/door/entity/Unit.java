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
public class Unit {

    private long id;

    private long buildId;

    private String name;

    private long code;

    private Date createTime;

    private Date updateTime;

}
