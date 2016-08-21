"use strict";
$(function () {
    function initCombo() {
        var buildCombo = $("#search-build"), unitCombo = $("#search-unit"), gatewayCombo = $("#search-gateway");

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
                gatewayCombo.combobox({
                    onBeforeLoad: function (param) {
                        param.unitId = unitCombo.combobox("getValue");
                    }
                });
            }
        });

        gatewayCombo.combobox({
            url: "gateway/list"
        });

    }

    initCombo();
});