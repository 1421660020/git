<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta HTTP-EQUIV="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <%@ include file="../common/head.jsp" %>
    <script src="static/js/check.js"></script>
    <title>Title</title>
    <style type="text/css">
    </style>

</head>
<body background="/Shop/static/img/1.jpg">
<div align="center">
    <form method="post" action="/Shop/login" id="login"><!---登录板块-->
        <input type="hidden" name="action" value="login"/>
        <table border="1" align="center">
            <tr>
                <td><em>欢迎登录书城</em></td>
                <td><h3 id="msg">${requestScope.msg}</h3></td>
            <tr>
                <td>用户名</td>
                <td><input type="text" name="username"/></td>
            </tr>
            <tr>
                <td>密码</td>
                <td><input type="password" name="password"/></td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="现在登录"/>
                </td>
                <td><a href="/Shop/page/jsp/login/register.jsp">立即注册</a></td>
            </tr>

        </table>

    </form>

</div>
</body>
</html>