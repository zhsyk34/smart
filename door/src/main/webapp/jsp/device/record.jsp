<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="/jsp/commons/commons.jsp" %>
    <title>record</title>
    <script src="js/record.js"></script>
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
                <td>房屋名称:</td>
                <td><input id="search-house" class="easyui-textbox"></td>
                <td>门锁名称:</td>
                <td><input id="search-lock" class="easyui-textbox"></td>
                <td><a id="search" class="easyui-linkbutton" iconCls="icon-search">查询</a></td>
                <td><a id="clear" class="easyui-linkbutton" iconCls="icon-clear">重置</a></td>
            </tr>
            </tbody>
        </table>
    </div>

    <div id="data"></div>
</div>
</body>
</html>