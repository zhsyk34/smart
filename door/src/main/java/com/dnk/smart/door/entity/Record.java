package com.dnk.smart.door.entity;

import com.dnk.smart.door.entity.dict.Action;
import com.dnk.smart.door.entity.dict.ActionType;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
//TODO
public class Record {

    private long id;

    private String uuid;// lock-uuid

    private Action action;// 指令

    private ActionType type;

    private int number;// 指纹或密码 id

    private String description;// 指令描述

    private Date eventTime;

    private Date createTime;

}
