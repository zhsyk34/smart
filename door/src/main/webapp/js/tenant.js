"use strict";
$(function () {
    function initCombo() {
        var buildCombo = $("#build-selector"), unitCombo = $("#unit-selector"), houseCombo = $("#house-selector");

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

        unitCombo.combobox({
            url: "unit/list",
            onChange: function () {
                houseCombo.combobox({
                    onBeforeLoad: function (param) {
                        param.unitId = unitCombo.combobox("getValue");
                    }
                });
            }
        });

        houseCombo.combobox({
            url: "house/list"
        });
    }

    $.base({
        urls: {
            find: "tenant/find",
            save: "tenant/save",
            remove: "tenant/delete",
            exist: null
        },
        gridOption: {
            title: "房屋列表",
            columns: [[
                {field: "", checkbox: true},
                {field: "build", title: "所属楼栋", width: 15},
                {field: "unit", title: "所属单元", width: 15},
                {field: "house", title: "所属房屋", width: 15},
                {field: "name", title: "姓名", width: 15},
                {field: "idCard", title: "身份证号", width: 15},
                {field: "phone", title: "联系电话", width: 15},
                {field: "gender", title: "性别", width: 15},
                {field: "email", title: "邮箱", width: 15},
                {field: "used", title: "启用", width: 10},
                {field: "createTime", title: "创建时间", width: 25},
                {field: "updateTime", title: "修改时间", width: 25}
            ]]
        }, before: function () {
            initCombo();
        },
        beforeOpenMod: function (row) {
            $("#build-selector").combobox("setValue", row.buildId).combobox("setText", row.build);
            $("#unit-selector").combobox("setValue", row.unitId).combobox("setText", row.unit);
            $("#house-selector").combobox("setValue", row.houseId).combobox("setText", row.house);
        },
        findParams: function () {
            return {
                build: $.trim($("#search-build").val()),
                unit: $.trim($("#search-unit").val()),
                house: $.trim($("#search-house").val()),
                name: $.trim($("#search-name").val()),
                gender: $.trim($("#search-gender").val()),
                idCard: $.trim($("#search-idCard").val()),
                phone: $.trim($("#search-phone").val())
            };
        }
    });
});
