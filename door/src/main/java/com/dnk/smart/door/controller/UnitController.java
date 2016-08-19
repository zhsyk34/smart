package com.dnk.smart.door.controller;

import com.dnk.smart.door.entity.Unit;
import com.dnk.smart.door.vo.EasyGrid;
import com.dnk.smart.door.vo.Feedback;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/unit")
public class UnitController extends CommonsController {

    @RequestMapping(value = "/list")
    @ResponseBody
    public List<Unit> list(Long buildId) {
        return buildId == null ? null : unitService.findList(buildId, null, -1, -1);
    }

    @RequestMapping(value = "/find")
    @ResponseBody
    public EasyGrid<Map<String, Object>> find(String build, String unit, int page, int rows) {
        EasyGrid<Map<String, Object>> grid = new EasyGrid<>();
        List<Map<String, Object>> list = unitService.findList(build, unit, page, rows);
        int total = unitService.count(build, unit);
        grid.setRows(list);
        grid.setTotal(total);
        return grid;
    }

    @RequestMapping(value = "/save")
    @ResponseBody
    public String save(Unit unit) {
        if (unit.getBuildId() <= 0) {
            return Feedback.ERROR.toString();
        }
        long id = unit.getId();
        if (id <= 0) {
            unitService.save(unit);
            return Feedback.CREATE.toString();
        }

        unit.setUpdateTime(new Date());
        unitService.update(unit);
        return Feedback.UPDATE.toString();
    }

    @RequestMapping(value = "/delete")
    @ResponseBody
    public String delete(long[] ids) {
        if (ids == null || ids.length == 0) {
            return Feedback.ERROR.toString();
        }
        if (unitService.relate(ids)) {
            return Feedback.RELATE.toString();
        }
        unitService.delete(ids);
        return Feedback.DELETE.toString();
    }

    @RequestMapping(value = "/exist")
    @ResponseBody
    public boolean exist(Integer id, int code) {
        return unitService.exist(id, code);
    }
}
