package com.dnk.smart.door.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Gateway {

    private long id;

    private long unitId;

    private String sn;// 识别码,出厂设置

    private String udid;// sn加密

    private String name;

    private String ip;

    private int port;

    private String remote;

    private String version;

    private String qrCode;

    private Date createTime;

    private Date updateTime;

}
