package Servlet;

import com.google.gson.Gson;
import pojo.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author Administrator
 * @Date 2021/12/8 4:14
 * @Version 1.0
 */
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if ("123".equals(username) && "123".equals(password)) {
            req.getSession().setAttribute("user", username);
            resp.getWriter().write("登陆成功！");
        } else {
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("LoginServlet被访问");
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");
        System.out.println(req.getParameter("2"));
        Gson g = new Gson();
        String json = g.toJson(new Person(2, req.getParameter("2")));
        resp.getWriter().write(json);



    }
}
