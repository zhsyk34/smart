package com.dnk.smart.door.controller;

import com.dnk.smart.door.entity.Tenant;
import com.dnk.smart.door.vo.EasyGrid;
import com.dnk.smart.door.vo.Feedback;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/tenant")
public class TenantController extends CommonsController {

    @RequestMapping(value = "/find")
    @ResponseBody
    public EasyGrid<Map<String, Object>> find(String build, String unit, String house, String name, String idCard, String gender, String phone, int page, int rows) {
        EasyGrid<Map<String, Object>> grid = new EasyGrid<>();
        List<Map<String, Object>> list = tenantService.findList(build, unit, house, name, idCard, gender, phone, page, rows);
        int total = tenantService.count(build, unit, house, name, idCard, gender, phone);
        grid.setRows(list);
        grid.setTotal(total);
        return grid;
    }

    @RequestMapping(value = "/save")
    @ResponseBody
    public String save(Tenant tenant) {
        if (tenant.getId() <= 0) {
            tenantService.save(tenant);
            return Feedback.CREATE.toString();
        }

        tenantService.update(tenant);
        return Feedback.UPDATE.toString();
    }

    @RequestMapping(value = "/delete")
    @ResponseBody
    public String delete(long[] ids) {
        if (ids == null || ids.length == 0) {
            return Feedback.ERROR.toString();
        }
        tenantService.delete(ids);
        return Feedback.DELETE.toString();
    }

}
