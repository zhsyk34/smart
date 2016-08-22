package com.dnk.smart.door.controller;

import com.dnk.smart.door.entity.dict.RecordType;
import com.dnk.smart.door.vo.EasyGrid;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/record")
public class RecordController extends CommonsController {

    @RequestMapping(value = "/cloud")
    @ResponseBody
    public EasyGrid<Map<String, Object>> findCloud(String build, String unit, String house, String lock, int page, int rows) {
        EasyGrid<Map<String, Object>> grid = new EasyGrid<>();
        List<Map<String, Object>> list = recordService.findList(RecordType.CLOUD, build, unit, house, lock, page, rows);
        int total = recordService.count(RecordType.CLOUD, build, unit, house, lock);
        System.out.println(list.size());
        grid.setRows(list);
        grid.setTotal(total);
        return grid;
    }

    @RequestMapping(value = "/local")
    @ResponseBody
    public EasyGrid<Map<String, Object>> findLocal(String build, String unit, String house, String lock, int page, int rows) {
        EasyGrid<Map<String, Object>> grid = new EasyGrid<>();
        List<Map<String, Object>> list = recordService.findList(RecordType.LOCAL, build, unit, house, lock, page, rows);
        int total = recordService.count(RecordType.LOCAL, build, unit, house, lock);
        grid.setRows(list);
        grid.setTotal(total);
        return grid;
    }
}
