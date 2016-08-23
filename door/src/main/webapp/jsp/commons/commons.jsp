<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
%>
<%@ page trimDirectiveWhitespaces="true" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<base href="<%=basePath%>"/>
<%--init css--%>
<link rel="stylesheet" href="css/init.css"/>
<%--easyui--%>
<link rel="stylesheet" href="js/lib/easyui/themes/default/easyui.css"/>
<link rel="stylesheet" href="js/lib/easyui/themes/icon.css"/>
<script src="js/lib/easyui/jquery.min.js"></script>
<script src="js/lib/easyui/jquery.easyui.min.js"></script>
<script src="js/lib/easyui/locale/easyui-lang-zh_CN.js"></script>
<%--base js--%>
<script src="js/lib/message.js"></script>
<script src="js/lib/easy.js"></script>
<script src="js/lib/crud.js"></script>
<script src="js/lib/view.js"></script>
<%--rewrite easy css--%>
<link rel="stylesheet" href="css/easy.css"/>
<script>
    var basePath = "<%=basePath%>";
    var timeout = "<%=session.getAttribute("user")%>";
</script>
<script src="js/lib/redirect.js"></script>