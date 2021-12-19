<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/12/7
  Time: 2:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <c:choose>
        <c:when test="${requestScope.user.username}!=null">
            欢迎${requestScope.user.username}
        </c:when>
        <c:otherwise>
            <a href="http://localhost:8080/Shop/page/jsp/login/login.jsp">登录</a><a>注册</a>
        </c:otherwise>
    </c:choose>
</div>
<form action="/Shop/orderServlet" method="post">
    <input hidden="hidden" name="action" value="balance">
    <table>
        <c:forEach begin="0" end="${sessionScope.cart.items.size}" items="${sessionScope.cart.items}" var="book">
            <tr>
                id
                <td>${book.id}</td>
                商品名
                <td>${book.name}</td>
                商品单价
                <td>${book.price}</td>
                商品数量
                <td><input type="text" name="count" value="${book.price}"/></td>
            </tr>
        </c:forEach>
    </table>
    <input type="button" value="清空购物车"/>
    <input type="submit" value="结算"/>
</form>
</body>
</html>
