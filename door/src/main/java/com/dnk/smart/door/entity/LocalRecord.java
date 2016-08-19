package com.dnk.smart.door.entity;

import com.dnk.smart.door.entity.dict.Action;
import com.dnk.smart.door.entity.dict.ActionType;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
//TODO
public class LocalRecord {

    private long id;

    private String uuid;

    private Action action;

    private ActionType type;

    private int number;

    private String description;

    private Date eventTime;

    private Date createTime;

}
