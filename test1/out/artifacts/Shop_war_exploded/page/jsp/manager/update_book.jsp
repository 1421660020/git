<%@ page import="com.web.bean.Book" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/12/3
  Time: 18:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        tr, th {

            font-style: initial;
        }

        td {
            text-align: left;

        }

        li {
            text-align: left;
        }

        a {
            color: blue;
            text-decoration: underline;
        }

    </style>
</head>
<body>
<form action="/Shop/booksServlet" method="post">
    <input hidden="hidden" name="action" value="updateSuccess">
    <table border="1">
           <input type="hidden" name="id" value="${requestScope.update_book.id}"></td>
        <tr>
            <td>图书名</td>
            <td><input type="text" name="name" value="${requestScope.update_book.name}"></td>
        </tr>
        <tr>
            <td>图书价格</td>
            <td><input type="text" name="price" value="${requestScope.update_book.price}"></td>
        </tr>
        <tr>
            <td>作者</td>
            <td><input type="text" name="author" value="${requestScope.update_book.author}"></td>
        </tr>
        <tr>
            <td>图书销量</td>
            <td><input type="text" name="sales" value="${requestScope.update_book.sales}"></td>
        </tr>
        <tr>
            <td>图书余量</td>
            <td><input type="text" name="stock" value="${requestScope.update_book.stock}"></td>
        </tr>
        <tr>
           <%-- <td>图书封面</td>
            <%
                Book book = (Book) request.getAttribute("update_book");
            %>
            <td><img src="/Shop/<%=book.getImgpath()%>" height="100" width="100">
            </td>
            <td>
                <input type="file" name="file">
            <td>--%>
        </tr>
        <tr>
            <td><input type="submit" value="确认修改"></td>
        </tr>
    </table>
</form>
</body>
</html>
