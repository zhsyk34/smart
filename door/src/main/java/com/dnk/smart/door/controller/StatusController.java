package com.dnk.smart.door.controller;

import com.dnk.smart.door.entity.Status;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/status")
public class StatusController extends CommonsController {

    @RequestMapping(value = "/find")
    @ResponseBody
    public List<Map<Long, List<Status>>> find(Long unitId, Long gatewayId) {
        return statusService.findList(unitId, gatewayId);
    }
}
