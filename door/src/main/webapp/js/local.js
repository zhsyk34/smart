"use strict";
$(function () {
    $.base({
        urls: {
            find: "record/local"
        },
        gridOption: {
            title: "开锁记录",
            columns: [[
                {field: "", checkbox: true},
                {field: "id", title: "id", width: 5},
                {field: "build", title: "楼栋", width: 10},
                {field: "unit", title: "单元", width: 10},
                {field: "house", title: "房屋", width: 10},
                {field: "locks", title: "锁", width: 10},
                {field: "type", title: "开锁类型", width: 10},
                {field: "tenant", title: "开锁人员", width: 10},
                {field: "pass", title: "指纹/密码编号", width: 10},
                {field: "description", title: "说明", width: 20},
                {field: "eventTime", title: "记录时间", width: 15}
            ]]
        },
        findParams: function () {
            return {
                build: $.trim($("#search-build").val()),
                unit: $.trim($("#search-unit").val()),
                house: $.trim($("#search-house").val()),
                lock: $.trim($("#search-lock").val())
            };
        }
    });
});







