package com.dnk.smart.door.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class SessionInfo {

    private long id;

//    private String sn;

    private String udid;

    private String ip;

    private int tcpport;

    private int udpprot;

    private int curudprot;

    private Date createTime;

    private Date updateTime;

}
