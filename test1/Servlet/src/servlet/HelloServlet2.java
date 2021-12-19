package servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author Administrator
 * @Date 2021/11/17 3:59
 * @Version 1.0
 */
public class HelloServlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request.getMethod());
        ServletConfig servletConfig=getServletConfig();
        System.out.println(servletConfig.getServletName());
        System.out.println("name："+servletConfig.getInitParameter("name"));
        System.out.println(servletConfig.getServletContext().getRealPath("/"));
        System.out.println(servletConfig.getServletContext()==getServletContext());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        ServletConfig servletConfig=getServletConfig();
//        System.out.println(servletConfig.getServletContext()==getServletContext());

        System.out.println(request.getRequestURI()+"\n"+request.getRequestURL());//相对路径绝对路径
        System.out.println(request.getContextPath());//项目路径
        request.getRemoteHost();
        System.out.println(request.getRemoteUser());

    }
}
