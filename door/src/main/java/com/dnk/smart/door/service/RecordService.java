package com.dnk.smart.door.service;

import com.dnk.smart.door.entity.dict.RecordType;

import java.util.List;
import java.util.Map;

public interface RecordService {

    List<Map<String, Object>> findList(RecordType from, String build, String unit, String house, String lock, int pageNo, int pageSize);

    int count(RecordType from, String build, String unit, String house, String lock);
}
