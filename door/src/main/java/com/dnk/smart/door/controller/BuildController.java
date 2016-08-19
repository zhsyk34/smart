package com.dnk.smart.door.controller;

import com.dnk.smart.door.entity.Build;
import com.dnk.smart.door.vo.EasyGrid;
import com.dnk.smart.door.vo.Feedback;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/build")
public class BuildController extends CommonsController {

    @RequestMapping(value = "/list")
    @ResponseBody
    public List<Build> list(String name) {
        return buildService.findList(name, -1, -1);
    }

    @RequestMapping(value = "/find")
    @ResponseBody
    public EasyGrid<Build> find(String name, int page, int rows) {
        EasyGrid<Build> grid = new EasyGrid<>();
        List<Build> list = buildService.findList(name, page, rows);
        int total = buildService.count(name);
        grid.setRows(list);
        grid.setTotal(total);
        return grid;
    }

    @RequestMapping(value = "/save")
    @ResponseBody
    public String save(Build build) {
        long code = build.getCode();

        if (StringUtils.isEmpty(build.getName()) || code <= 0) {
            return Feedback.ERROR.toString();
        }
        if (buildService.exist(build.getId(), code)) {
            return Feedback.EXIST.toString();
        }

        if (build.getId() <= 0) {
            buildService.save(build);
            return Feedback.CREATE.toString();
        }

        build.setUpdateTime(new Date());
        buildService.update(build);
        return Feedback.UPDATE.toString();
    }

    @RequestMapping(value = "/delete")
    @ResponseBody
    public String delete(long[] ids) {
        if (ids == null || ids.length == 0) {
            return Feedback.ERROR.toString();
        }
        if (buildService.relate(ids)) {
            return Feedback.RELATE.toString();
        }
        buildService.delete(ids);
        return Feedback.DELETE.toString();
    }

    @RequestMapping(value = "/exist")
    @ResponseBody
    public boolean exist(Integer id, int code) {
        return buildService.exist(id, code);
    }

}
