<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="/jsp/commons/commons.jsp" %>
    <title>tenant</title>
    <script src="js/tenant.js"></script>
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
                <td>性别:</td>
                <td>
                    <select id="search-gender">
                        <option value="" selected>全部</option>
                        <option value="male">男</option>
                        <option value="female">女</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>姓名:</td>
                <td><input id="search-name" class="easyui-textbox"></td>
                <td>身份证:</td>
                <td><input id="search-idCard" class="easyui-textbox"></td>
                <td>联系电话:</td>
                <td><input id="search-phone" class="easyui-textbox"></td>
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
                    <td><input id="build-selector" name="buildId"></td>
                </tr>
                <tr>
                    <td>所属单元:</td>
                    <td><input id="unit-selector" name="unitId"></td>
                </tr>
                <tr>
                    <td>所属房屋:</td>
                    <td><input id="house-selector" name="houseId"></td>
                </tr>
                <tr>
                    <td>姓名:</td>
                    <td><input class="easyui-textbox" name="name" data-options="required:true,validType:'length[4,30]'"></td>
                </tr>
                <tr>
                    <td>身份证:</td>
                    <td><input class="easyui-textbox" name="idCard" data-options="required:true,validType:'length[15,18]'"></td>
                </tr>
                <tr>
                    <td>性别:</td>
                    <td><label><input type="radio" name="gender" value="male" checked>男</label> <label><input type="radio" name="gender" value="female">女</label></td>
                </tr>
                <tr>
                    <td>邮箱:</td>
                    <td><input class="easyui-textbox" name="email" data-options="required:true,validType:'email'"></td>
                </tr>
                <tr>
                    <td>手机:</td>
                    <td><input class="easyui-textbox" name="phone" data-options="required:true,validType:'length[7,11]'"></td>
                </tr>
                <tr>
                    <td>是否启用:</td>
                    <td><label><input name="used" type="radio" value="true" checked>是</label> <label><input name="used" type="radio" value="false">否</label></td>
                </tr>
            </table>
        </form>
    </div>
</div>
</body>
</html>
