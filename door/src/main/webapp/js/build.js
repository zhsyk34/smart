"use strict";
$(function () {
    $.base({
        urls: {
            find: "build/find",
            save: "build/save",
            remove: "build/delete",
            exist: "build/exist"
        },
        gridOption: {
            title: "楼栋列表",
            columns: [[
                {field: "", checkbox: true},
                {field: "name", title: "楼栋名称", editor: "text", width: 20},
                {field: "code", title: "楼栋编号", editor: "text", width: 20},
                {field: "createTime", title: "创建时间", editor: "text", width: 30},
                {field: "updateTime", title: "修改时间", editor: "text", width: 30}
            ]]
        },
        findParams: function () {
            return {name: $.trim($("#search-name").val())};
        },
        existParam: function () {
            return {
                id: parseInt($("input[name=id]").val()) || 0,
                code: parseInt($("input[name=code]").val())
            };
        }
    });
});




