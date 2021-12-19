package com.web.controller;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

/**
 * @Author Administrator
 * @Date 2021/11/28 19:43
 * @Version 1.0
 */
public class DownLoad extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fileName = "异常类型.PNG";
        String mimeType = getServletContext().getMimeType(fileName);
        System.out.println(mimeType);
        //需要放在最上面
        response.setContentType(mimeType);
        response.setCharacterEncoding("utf-8");
        //设置是否用于下载
        response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName,"utf-8"));
       InputStream inputStream = getServletContext().getResourceAsStream("/static/img/" + fileName);
        System.out.println(getServletContext().getResource("/static/img/" + fileName));
       // InputStream inputStream=new FileInputStream(getServletContext().getRealPath("/")+"/static/img/"+fileName);
        OutputStream outputStream = response.getOutputStream();
        IOUtils.copy(inputStream, outputStream);
        IOUtils.closeQuietly(inputStream);
        IOUtils.closeQuietly(outputStream);

        //设置响应的类型

    }
}
