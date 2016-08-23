<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
%>
<html>
<head>
    <base href="<%=basePath%>"/>
    <link rel="stylesheet" href="css/init.css">
    <link rel="stylesheet" href="css/login.css">
    <title>登录</title>
    <script src="js/lib/easyui/jquery.min.js"></script>
    <script src="js/login.js"></script>
</head>
<body>
<div id="container">
    <form>
        <input id="name" placeholder="用户名">
        <input id="password" type="password" placeholder="密码">
        <button id="logon" class="btn btn-primary" type="button">提交</button>
    </form>
</div>
</body>
</html>
