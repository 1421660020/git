package com.web.controller;

import com.web.bean.User;
import com.web.service.UserSerice;
import com.web.service.imp.UserServiceImp;
import com.web.utils.WebUtils;
import org.apache.commons.logging.impl.Log4JLogger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.logging.FileHandler;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

/**
 * @Author Administrator
 * @Date 2021/11/19 21:22
 * @Version 1.0
 */

public class Login extends BaseServlet {
    private UserSerice u = new UserServiceImp();


    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Log4JLogger l = new Log4JLogger();
        FileHandler f = new FileHandler("C:\\Users\\Administrator\\Desktop\\1.jpg", true);

        l.info("login被" + request.getRemoteAddr() + "访问");

        User user = new User();
        WebUtils.changeParaToBean(request.getParameterMap(), user);
        //  System.out.println(u.login(new User(null, username, password, null)));
        if (u.login(user)) {//登录失败
            request.setAttribute("msg", "用户名或密码不正确");
            request.getRequestDispatcher("page/jsp/login/login.jsp").forward(request, response);
        } else {//登录成功
            request.getSession().setAttribute("userName", user.getUsername());
            request.getRequestDispatcher("page/jsp/login/login_success.jsp").forward(request, response);

        }

    }


    protected void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        WebUtils.changeParaToBean(request.getParameterMap(), user);
        HttpSession session = request.getSession();
        Object code = session.getAttribute(KAPTCHA_SESSION_KEY);
        //删除验证码
        session.removeAttribute(KAPTCHA_SESSION_KEY);
        //验证码通过才允许操作
        if (code != null && request.getParameter("code").equalsIgnoreCase((String) code)) {
            if (!u.existsUsername(user.getUsername())) {
                u.registUser(user);
                response.sendRedirect("/Shop/page/jsp/manager//books.jsp");
            } else {
                request.setAttribute("msg", "用户名已存在！");
                request.getRequestDispatcher("/page/jsp/login/register.jsp").forward(request, response);
            }

            //    }
        } else {
            System.out.println("验证码不正确");
        }

    }
}
