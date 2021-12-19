<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/11/19
  Time: 21:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<form action="identityCode" method="get">
    <input type="hidden" name="action" value="checkCode"/>
    <input type="text" name="code"/><img src="identityCode?action=getCode"/>
    <input type="submit" value="提交"/>
</form>
<img src="kaptchaServlet.jpg" width="100" height="20"/>
</body>
</html>
