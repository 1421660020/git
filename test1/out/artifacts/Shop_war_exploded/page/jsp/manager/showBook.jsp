<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/12/7
  Time: 2:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@ page import="com.web.bean.Book" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>success</title>
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

<%
    int pageNum = 1;
    List<Book> books = null;
    String isChange = request.getParameter("isChange");
    System.out.println("isChange：" + isChange);
    if ("true".equals(isChange)) {
        books = (List<Book>) request.getAttribute("books");
        session.setAttribute("books", books);
    } else if ("false".equals(isChange)) {
        books = (List<Book>) session.getAttribute("books");
        pageNum = Integer.parseInt(request.getParameter("pageNum"));
    }
    System.out.println(books.size());
    System.out.println(pageNum);
    List<Book> pageBooks = null;
    pageBooks = new ArrayList<>();
    if (pageNum == 1) {
        for (int i = 0; i < 5; i++) {
            pageBooks.add(books.get(i));
        }
    } else {
        if (pageNum * 5 >= books.size()) {
            for (int i = 5 * (pageNum - 1) + 1; i < books.size() + 1; i++) {
                System.out.println(i);
                pageBooks.add(books.get(i - 1));
            }
        } else {
            for (int i = 5 * (pageNum - 1) + 1; i < (5 * (pageNum - 1)) + 6; i++) {
                System.out.println(i);
                pageBooks.add(books.get(i - 1));
            }
        }
    }
    System.out.println(pageBooks);
%>
<div align="center" id="show_books">
    <table>
        <%

            for (int i = 0; i < pageBooks.size(); i++) {
                Book book = pageBooks.get(i);%>
        <div>
            <tr>
                <td>
                    图书id：<%=book.getId()%>
                </td>
                <td>封面：<img src="/Shop/<%=book.getImgpath()%>" width="100px" height="100"/></td>
                <td>书名： <%=book.getName()%>
                </td>
                <td>价格： <%=book.getPrice()%>
                </td>
                <td>
                    作者：<%=book.getAuthor()%>
                </td>
                <td>销量： <%=book.getSales()%>
                </td>
                <td>余量： <%=book.getStock()%>
                </td>
                <td><a href="/Shop/cartServlet?action=addCartItem&id=<%=book.getId()%>" onclick="function x() {

                }">加入购物车</a>
                </td>
            </tr>
        </div>
        <% }
        %>
    </table>
    <%
        int end = 0;
        if (books.size() % 5 == 0) {
            end = books.size() / 5;
        } else {
            end = books.size() / 5 + 1;
        }
        for (int i = 1; i <= end; i++) {%>
    <a href="/Shop/page/jsp/manager/books.jsp?pageNum=<%=i%>&isChange=false">第<%=i%>页</a>
    <%}%>
    共<%=books.size()%>条记录
</div>
<%--修改图书界面--%>


</body>
</html>
</body>
</html>
