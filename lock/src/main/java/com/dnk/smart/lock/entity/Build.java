package com.dnk.smart.lock.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Build {

    private long id;

    private String name;

    private Date createTime;

    private Date updateTime;

}
