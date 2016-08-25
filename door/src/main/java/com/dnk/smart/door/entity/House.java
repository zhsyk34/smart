package com.dnk.smart.door.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * relate:locks,tenant
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class House {

    private long id;

    private long unitId;

    private String name;

    private long code;

    private Date createTime;

    private Date updateTime;

}
