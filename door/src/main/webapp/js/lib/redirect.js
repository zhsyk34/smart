$.ajaxSetup({
    cache: false,
    traditional: true,
    type: "POST",
    complete: function (xhr) {
        var timeout = xhr.getResponseHeader("timeout");
        (timeout === "true") && redirect();
    }
});

$(function () {
    (!timeout) && redirect();
});

function redirect() {
    var top = getTopWindow();
    top.location.href = basePath + "jsp/login.jsp";

    function getTopWindow() {
        var w = window;
        while (w != w.parent) {
            w = w.parent;
        }
        return w;
    }
}