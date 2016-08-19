package com.dnk.smart.door.controller;

import com.dnk.smart.door.entity.Build;
import com.dnk.smart.door.entity.Lock;
import com.dnk.smart.door.vo.EasyGrid;
import com.dnk.smart.door.vo.Feedback;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/lock")
public class LockController extends CommonsController {

    @RequestMapping(value = "/list")
    @ResponseBody
    public List<Build> list(String name) {
        return null;
    }

    @RequestMapping(value = "/find")
    @ResponseBody
    public EasyGrid<Map<String, Object>> find(String build, String unit, String house, String name, int page, int rows) {
        EasyGrid<Map<String, Object>> grid = new EasyGrid<>();
        List<Map<String, Object>> list = lockService.findList(build, unit, house, name, page, rows);
        int total = lockService.count(build, unit, house, name);
        grid.setRows(list);
        grid.setTotal(total);
        return grid;
    }

    @RequestMapping(value = "/save")
    @ResponseBody
    public String save(Lock lock) {
        // TODO
        // 0.对码通讯 if(ok)=>
        // 1.查询网关未被占用的最小设备号 X
        // 2.携带X发送控制指令
        // 3.测试控制
        // 4.保存
        if (lock.getId() <= 0) {
            lockService.save(lock);
            return Feedback.CREATE.toString();
        }
        lockService.update(lock);
        return Feedback.UPDATE.toString();
    }

    @RequestMapping(value = "/delete")
    @ResponseBody
    public String delete(long[] ids) {
        if (ids == null || ids.length == 0) {
            return Feedback.ERROR.toString();
        }
        if (lockService.relate(ids)) {
            return Feedback.RELATE.toString();
        }
        lockService.delete(ids);
        return Feedback.DELETE.toString();
    }

    @RequestMapping(value = "/exist")
    @ResponseBody
    public boolean exist(Integer id, int code) {
        return false;
    }
}
