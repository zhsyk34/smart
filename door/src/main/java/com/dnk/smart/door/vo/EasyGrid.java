package com.dnk.smart.door.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class EasyGrid<Entity> {

    private List<Entity> rows;

    private int total;

}
