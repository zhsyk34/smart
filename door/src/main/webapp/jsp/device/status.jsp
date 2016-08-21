<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="/jsp/commons/commons.jsp" %>
    <title>status</title>
    <script src="js/status.js"></script>
    <link rel="stylesheet" href="css/status.css"/>
</head>
<body>
<div>
    <div id="nav">
        <table>
            <tbody>
            <tr>
                <td>楼栋名称:</td>
                <td><input id="search-build" class="easyui-textbox"></td>
                <td>单元名称:</td>
                <td><input id="search-unit" class="easyui-textbox"></td>
                <td>网关名称:</td>
                <td><input id="search-gateway" class="easyui-textbox"></td>
            </tr>
            </tbody>
        </table>
    </div>

    <div id="data"></div>

    <div id="thumbnail">
        <div class="gateway"></div>
    </div>
</div>
</body>
</html>