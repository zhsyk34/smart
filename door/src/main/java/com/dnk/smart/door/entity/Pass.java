package com.dnk.smart.door.entity;

import com.dnk.smart.door.entity.dict.PassType;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
//TODO
public class Pass {

    private long id;

    private long userId;

    private long lockId;// TODO lock-uuid,houseId,houseName?

    private PassType type;

    private int number;

    private Date createTime;

    private Date updateTime;

}
