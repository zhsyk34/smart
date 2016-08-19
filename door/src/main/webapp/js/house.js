"use strict";
$(function () {
    function initCombo() {
        var buildCombo = $("#build-selector"), unitCombo = $("#unit-selector");

        buildCombo.combobox({
            url: "build/list",
            onChange: function () {
                unitCombo.combobox({
                    onBeforeLoad: function (param) {
                        param.buildId = buildCombo.combobox("getValue");
                    }
                });
            }
        });

        unitCombo.combobox({url: "unit/list"});
    }

    $.base({
        urls: {
            find: "house/find",
            save: "house/save",
            remove: "house/delete",
            exist: "house/exist"
        },
        gridOption: {
            title: "房屋列表",
            columns: [[
                {field: "", checkbox: true},
                {field: "build", title: "所属楼栋", width: 15},
                {field: "unit", title: "所属单元", width: 15},
                {field: "name", title: "房屋名称", width: 15},
                {field: "createTime", title: "createTime", width: 20},
                {field: "updateTime", title: "updateTime", width: 20}
            ]]
        },
        before: function () {
            initCombo();
        },
        beforeOpenMod: function (row) {
            $("#build-selector").combobox("setValue", row.buildId).combobox("setText", row.build);
            $("#unit-selector").combobox("setValue", row.unitId).combobox("setText", row.unit);
        },
        findParams: function () {
            return {
                build: $.trim($("#search-build").val()),
                unit: $.trim($("#search-unit").val()),
                house: $.trim($("#search-house").val()),
            };
        },
        existParam: function () {
            return {
                id: parseInt($("input[name=id]").val()) || 0,
                code: parseInt($("input[name=code]").val())
            };
        }
    });
});







