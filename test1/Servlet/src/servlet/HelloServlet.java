package servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * @Author Administrator
 * @Date 2021/11/17 1:01
 * @Version 1.0
 */
public class HelloServlet implements Servlet {
    public HelloServlet() {
        System.out.println("构造器被访问");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init方法被访问了");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("service方法被访问了");

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("destroy方法被访问了");
    }
}
