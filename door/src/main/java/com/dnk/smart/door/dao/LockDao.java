package com.dnk.smart.door.dao;

import com.dnk.smart.door.entity.Lock;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface LockDao extends CommonsDao<Lock> {

	List<Lock> findList(@Param("gatewayId") Long gatewayId, @Param("houseId") Long houseId, @Param("uuid") String uuid, @Param("name") String name, @Param("offset") int offset, @Param("limit") int limit);

	List<Map<String, Object>> findMap(@Param("build") String build, @Param("unit") String unit, @Param("house") String house, @Param("name") String name, @Param("offset") int offset, @Param("limit") int limit);

	int countMap(@Param("build") String build, @Param("unit") String unit, @Param("house") String house, @Param("name") String name);

	// 查询设备号
	List<Integer> findDevice(long gatewayId);

	int update(@Param("id") long id, @Param("name") String name, @Param("password") String password);
}
