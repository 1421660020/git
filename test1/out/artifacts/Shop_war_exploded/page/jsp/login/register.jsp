<%@ page import="com.web.utils.identityCode" %>
<%@ page import="java.io.File" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta HTTP-EQUIV="pragma">
    <title>Title</title>
    <base href="http://localhost:8080/Shop/"/>
    <script src="static/js/jquery-1.7.2.js"></script>
    <script type="text/javascript">
        $(function () {
            alert(1);
            $("img").click(function () {
                this.src = "kaptchaServlet.jpg"
            });
        })

    </script>
    <%-- <%@ include file="../common/head.jsp" %>--%>
    <%-- <script type="text/javascript">
         $(function () {
             $("[type='submit']").click(function () {
                 if ($("[name='username']").val().trim() === "") {
                     this.val("用户名为空");
                     return false;
                 } else if ($("[name='password']").val().trim() === "") {
                     this.val("密码为空");
                     return false;
                 }
             })
         });
     </script>--%>
</head>
<body>
<%--<script type="text/javascript">
    $(function () {
// 给注册绑定单击事件
        $("[type='submit']").click(function () {
// 验证用户名：必须由字母，数字下划线组成，并且长度为5到12位
//1 获取用户名输入框里的内容
            var usernameText = $("#username").val();
//2 创建正则表达式对象
            var usernamePatt = /^\w{5,12}$/;
//3 使用test方法验证
            if (!usernamePatt.test(usernameText)) {
//4 提示用户结果
                $("h5:not(first)").text("用户名不合法！");

                return false;
            }
//验证密码：必须由字母，数字下划线组成，并且长度为5到12位
//1 获取用户名输入框里的内容
            var passwordText = $("#password").val();
//2 创建正则表达式对象
            var passwordPatt = /^\w{5,12}$/;
//3 使用test方法验证
            if (!passwordPatt.test(passwordText)) {
//4 提示用户结果
                $("h5:not(first)").text("密码不合法！");

                return false;
            }

// 验证确认密码：和密码相同
//1 获取确认密码内容
            var repwdText = $("#repwd").val();
//2 和密码相比较
            if (repwdText != passwordText) {
//3 提示用户
                $("h5:not(first)").text("确认密码和密码不一致！");
                return false;
            }
// 邮箱验证：xxxxx@xxx.com
//1 获取邮箱里的内容
            var emailText = $("#email").val();
//2 创建正则表达式对象
            var emailPatt = /^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/;
//3 使用test方法验证是否合法
            if (!emailPatt.test(emailText)) {
//4 提示用户
                $("span.errorMsg").text("邮箱格式不合法！");
                return false;
            }
// 验证码：现在只需要验证用户已输入。因为还没讲到服务器。验证码生成。
            var codeText = $("#code").val();
//去掉验证码前后空格
// alert("去空格前：["+codeText+"]")
            codeText = $.trim(codeText);
// alert("去空格后：["+codeText+"]")
            if (codeText == null || codeText == "") {
//4 提示用户
                $("h5:not(first)").text("验证码不能为空！");
                return false;
            }
// 去掉错误信息
            $("h5:not(first)").text("");
        });
    });
</script>--%>
<br/>

}
<form method="post" action="login"><!---登录板块-->
    <input type="hidden" name="action" value="register">
    <table border="1" align="center">
        <tr>
            <td><h5>注册书城账号</h5></td>
            <td><h5>${requestScope.msg}</h5></td>
        </tr>
        <tr>
            <td>用户名</td>
            <td><input type="text" name="username"></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td>确认密码</td>
            <td><input type="password" name="checkPassWord"></td>
        </tr>
        <tr>
            <td>电子邮件</td>
            <td><input type="email" name="email"></td>
        </tr>
        <tr>
            <td>验证码</td>
            <td><input type="text" name="code">
                <img width="120" height="100" src="kaptchaServlet.jpg"></td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="注册">
            </td>
        </tr>
    </table>
</form>
</body>
</html>