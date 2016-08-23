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
                <td><input id="search-build" data-options="required:false"></td>
                <td>单元名称:</td>
                <td><input id="search-unit" data-options="required:false"></td>
                <td>网关名称:</td>
                <td><input id="search-gateway" data-options="required:false"></td>
                <td><a id="search" class="easyui-linkbutton" iconCls="icon-search">查询</a></td>
                <td><a id="clear" class="easyui-linkbutton" iconCls="icon-clear">重置</a></td>
            </tr>
            </tbody>
        </table>
    </div>

    <%--TODO--%>
    <div id="data"></div>

    <div id="show">
        <table>
            <tr>
                <td>关闭状态:</td>
                <td>
                    <input id="locked" class="easyui-textbox" readonly>
                </td>
            </tr>
            <tr>
                <td>上提反锁:</td>
                <td>
                    <input id="upLock" class="easyui-textbox" readonly>
                </td>
            </tr>
            <tr>
                <td>室内反锁:</td>
                <td>
                    <input id="backLock" class="easyui-textbox" readonly>
                </td>
            </tr>
            <tr>
                <td>电压:</td>
                <td>
                    <input id="voltage" class="easyui-textbox" readonly>
                </td>
            </tr>
            <tr>
                <td>是否在线:</td>
                <td>
                    <input id="online" class="easyui-textbox" readonly>
                </td>
            </tr>
            <tr>
                <td>记录时间:</td>
                <td>
                    <input id="time" class="easyui-textbox" readonly>
                </td>
            </tr>
        </table>
    </div>
</div>
</body>
</html>