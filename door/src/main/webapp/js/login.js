$(function () {
    $("#logon").on("click", function () {
        var name = $("#name").val();
        var password = $("#password").val();

        if (!/^[A-Za-z0-9]+$/.test(name)) {
            $.alert("请填写合法的用户名");
            return false;
        }

        if (!/^[A-Za-z0-9]+$/.test(password)) {
            $.alert("请填写合法的密码");
            return false;
        }

        $.ajax({
            url: "user/login",
            traditional: true,
            async: false,
            data: {name: name, password: password},
            success: function (data) {
                console.log(data);
                if (!!data) {
                    window.location.href = "jsp/index.jsp";
                } else {
                    alert("用户名密码不正确,请重新登录");
                    $("#password").val("");
                }
            }
        });
    });
});