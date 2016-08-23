"use strict";
$(function () {
    var buildCombo = $("#search-build"), unitCombo = $("#search-unit"), gatewayCombo = $("#search-gateway");

    function initCombo() {
        buildCombo.combobox({
            url: "build/list",
            onChange: function () {
                unitCombo.combobox({
                    onBeforeLoad: function (param) {
                        param.buildId = buildCombo.combobox("getValue");
                    }
                });
                console.log("build change========");
            }
        });

        unitCombo.combobox({
            url: "unit/list",
            onChange: function () {
                gatewayCombo.combobox({
                    onBeforeLoad: function (param) {
                        param.unitId = unitCombo.combobox("getValue");
                    }
                });
                console.log("unit change===========");
            }
        });

        gatewayCombo.combobox({
            url: "gateway/list",
            onChange: function () {
                console.log("gateway change==========");
            }
        });

        //TODO
        $("#clear").on("click", function () {
            buildCombo.combobox("clear");
            unitCombo.combobox("clear");
            gatewayCombo.combobox("clear");
        });

        $("#search").on("click", function () {
            load();
        });

    }

    initCombo();
    load();
    $("#show").dialog({title: "信息详情", closable: true, width: 360});

    function load() {
        var buildId = buildCombo.combobox("getValue");
        var unitId = unitCombo.combobox("getValue");
        var gatewayId = gatewayCombo.combobox("getValue");

        var wrap = $("#data").empty();

        var table = "<table class='thumbnail'><caption></caption><tr><td></td><td></td></tr><tr><td></td><td></td></tr><tr><td></td><td></td></tr></table>";
        $.ajax({
            url: "status/find",
            data: {buildId: buildId, unitId: unitId, gatewayId: gatewayId, page: 1, rows: 10},
            success: function (data) {
                data.forEach(function (element) {
                    var thumbnail = $(table);
                    var tds = thumbnail.find("td");
                    for (var gateway in element) {
                        thumbnail.find("caption").text(gateway);
                        var arr = element[gateway];
                        arr.forEach(function (status, index) {
                            var td = tds.eq(index);
                            td.data("info", status).text(status.locks);
                            listen(td);
                        });
                    }
                    wrap.append(thumbnail);
                });
            }
        });
    }

    function listen(td) {
        $(td).on("mouseover", function () {
            $(this).css({cursor: "pointer"});
        });

        $(td).on("click", function () {
            var info = $(this).data("info");
            if (info) {
                show(info);
                $("#show").dialog("open");
            }
        });

        function show(info) {
            console.log(info);
            $("#locked").textbox("setValue", info["locked"] ? "是" : "否");
            $("#upLock").textbox("setValue", info["upLock"] ? "是" : "否");
            $("#backLock").textbox("setValue", info["backLock"] ? "是" : "否");
            $("#online").textbox("setValue", info["online"] ? "是" : "否");
            $("#voltage").textbox("setValue", info["voltage"] / 10);
            $("#time").textbox("setValue", info["time"]);
        }
    }

});