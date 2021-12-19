<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/12/2
  Time: 5:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        div {
            align: center;
        }

        a {
            color: blue;
            text-decoration: underline;
        }
    </style>
    <script type="text/javascript">
        function bookManager() {
            document.getElementById("bookManager_form").submit();
        }

        function userManager() {
            document.getElementById("userManager_form").submit();
        }

        function showBookManager() {
            document.getElementById("showBook_form").submit();
        }

    </script>
</head>
<body>
<h3 align="center">后台管理系统</h3>
<a onclick="bookManager()">图书管理</a>
<a onclick="userManager()">用户管理</a>
<a onclick="showBookManager()">显示图书</a>
<form id="bookManager_form" action="/Shop/booksServlet" method="get">
    <input type="hidden" name="action" value="showAllBooks"/>
</form>
<form id="userManager_form" action="/Shop/booksServlet" method="get">
    <input type="hidden" name="action" value="showAllUsers"/>
</form>
<form id="showBook_form" action="/Shop/booksServlet" method="get">
    <input type="hidden" name="action" value="showBooks"/>
</form>

</body>
</html>
