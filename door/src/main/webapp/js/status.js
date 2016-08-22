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

    function load() {
        var buildId = buildCombo.combobox("getValue");
        var unitId = unitCombo.combobox("getValue");
        var gatewayId = gatewayCombo.combobox("getValue");

        // console.log("build", buildId);
        // console.log("unit", unitId);
        // console.log("gate", gatewayId);

        var wrap = $("#data").empty();
        $.ajax({
            url: "status/find",
            data: {buildId: buildId, unitId: unitId, gatewayId: gatewayId, page: 1, rows: 10},
            success: function (data) {
                data.forEach(function (element) {
                    var thumbnail = $("<div class='thumbnail'></div>");
                    for (var gateway in element) {
                        var arr = element[gateway];
                        arr.forEach(function (status) {
                            var div = $("<div></div>");
                            div.text(status.online);
                            console.log(status);

                            thumbnail.append(div);
                        });
                    }
                    wrap.append(thumbnail);
                });
            }
        });
    }

});