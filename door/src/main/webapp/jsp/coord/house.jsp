<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="/jsp/commons/commons.jsp" %>
    <title>house</title>
    <script src="js/house.js"></script>
</head>
<body>
<div id="wrap">
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
                <td><a id="search" class="easyui-linkbutton" iconCls="icon-search">查询</a></td>
                <td><a id="clear" class="easyui-linkbutton" iconCls="icon-clear">重置</a></td>
            </tr>
            </tbody>
        </table>
    </div>

    <div id="data"></div>

    <div id="editor">
        <form id="form" method="post">
            <table>
                <tr>
                    <td>所属楼栋:<input name="id" type="hidden"></td>
                    <td>
                        <input id="build-selector" type="text" name="buildId">
                    </td>
                </tr>
                <tr>
                    <td>所属单元:</td>
                    <td>
                        <input id="unit-selector" type="text" name="unitId">
                    </td>
                </tr>
                <tr>
                    <td>房屋名称:</td>
                    <td><input class="easyui-textbox" type="text" name="name" data-options="required:true,validType:'length[1,30]'"></td>
                </tr>
                <tr>
                    <td>房屋编号:</td>
                    <td><input class="easyui-numberbox" type="text" name="code" data-options="required:true,min:1"></td>
                </tr>
            </table>
        </form>
    </div>
</div>
</body>
</html>
