package com.dnk.smart.door.dao;

import com.dnk.smart.door.entity.Build;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BuildDao extends CommonsDao<Build> {

    List<Build> findList(@Param("name") String name, @Param("code") Long code, @Param("offset") int offset, @Param("limit") int limit);

    int countList(@Param("name") String name, @Param("code") Long code);
}
