package com.dnk.smart.door.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * 系统配置信息:临时密码
 *
 * @author Archimedes
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Config {

    private int id;

    private String name;

    private String value;

    private String description;

    private Date createTime;

    private Date updateTime;
}
