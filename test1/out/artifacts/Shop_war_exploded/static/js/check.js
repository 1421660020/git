

        $(function () {
                $("#register").click(function () {
                    window.location.replace("page/jsp/login/register.jsp");
                })
            }
        );
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


