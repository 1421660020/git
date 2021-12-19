<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/12/3
  Time: 19:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--<form id="bookManager_form" action="/Shop/booksServlet" action="get">
    <input type="hidden" name="action" value="showAllBooks"/>
</form>--%>
<form action="/Shop/booksServlet" method="post">
    <input type="hidden" name="action" value="insertBook"/>
    <table border="1">
        <tr>
            <td>图书名</td>
            <td><input type="text" name="name"/></td>
        </tr>
        <tr>
            <td>图书价格</td>
            <td><input type="text" name="price"/></td>
        </tr>
        <tr>
            <td>作者</td>
            <td><input type="text" name="author"/></td>
        </tr>
        <tr>
            <td>图书销量</td>
            <td><input type="text" name="sales"/></td>
        </tr>
        <tr>
            <td>图书余量</td>
            <td><input type="text" name="stock"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="确认添加"/></td>
        </tr>
    </table>
</form>
</body>
</html>
