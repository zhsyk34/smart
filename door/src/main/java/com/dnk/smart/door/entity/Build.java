package com.dnk.smart.door.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * relate:unit
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Build {

    private long id;

    private String name;

    private long code;

    private Date createTime;

    private Date updateTime;

}
