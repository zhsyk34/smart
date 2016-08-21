package com.dnk.smart.door.entity;

import com.dnk.smart.door.entity.dict.Action;
import com.dnk.smart.door.entity.dict.ActionType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Record {

    private long id;

    private String uuid;//gateway-udid + deviceNo->lock uuid

    private Action action;// 指令

    private ActionType type;

    private int pass;// 指纹或密码索引(编号)

    private String description;// 指令描述

    private Date eventTime;

    private Date createTime;

}
