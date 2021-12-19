<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/12/8
  Time: 4:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <script src="js/jquery-1.7.2.js"></script>
    <script type="text/javascript">
        function ajax_function() {
            // $.ajax({
            //     url: "http://localhost:8080/Filter/loginServlet",
            //     data: {
            //         2: "李四"
            //     },
            //     type: "GET",
            //     success: function (msg) {
            //         alert(msg.id + msg.name);
            //
            //     },
            //     dataType: "json"
            // });
            $.getJSON(
                "http://localhost:8080/Filter/loginServlet",
                "2='李四'",

                function (msg) {
                    alert(msg.id + msg.name);
                }
            );
        }


    </script>
</head>
<body>
<button type="button" onclick="ajax_function()">ajax</button>
<h1>111</h1>
</body>
</html>
