<%@ page import="com.web.bean.Book" %>
<%@ page import="com.web.bean.User" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>success</title>
    <style type="text/css">
        tr, th {
            border-color: red;
            font-style: initial;
        }
    </style>
    <script type="text/java">

    </script>
</head>
<body>

<%
    List<User> users = (List<User>) request.getAttribute("users");
%>
<div align="center">
    <table border="1">
        <th>
        <td>用户id</td>
        <td>用户名</td>
        <td>密码</td>
        <td>邮箱</td>
        <td>操作</td>
        </th>

        <%
            for (int i = 0; i < users.size(); i++) {
                User user = users.get(i);%>
        <tr>
            <div>
                <td>

                </td>
                <td><%=user.getId()%>
                </td>
                <td><%=user.getUsername()%>
                </td>
                <td><%=user.getPassword()%>
                </td>
                <td><%=user.getEmail()%>
                </td>
                <td><a id="update_user<%=i%>">修改</a> <a id="delete_user<%=i%>" }>删除</a></td>
            </div>

        </tr>
        <% }
        %>
    </table>
</div>
</body>
</html>