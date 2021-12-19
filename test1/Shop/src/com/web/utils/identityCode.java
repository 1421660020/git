package com.web.utils;

import com.web.controller.BaseServlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @Author Administrator
 * @Date 2021/11/22 20:46
 * @Version 1.0
 */
public class identityCode extends BaseServlet {
    private String identityString = "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public void checkCode(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("开始验证码校验...");
        String code1 = (String) req.getSession().getAttribute("code");
        System.out.println("code:" + code1);
        if (code1.equalsIgnoreCase(req.getParameter("code"))) {
            System.out.println("校验成功！");
        } else {
            System.out.println("校验失败！");
        }
    }

    public void getCode(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("getCode被访问");
        String stringBuffer = createCode(4);
        BufferedImage image = new BufferedImage(100, 20, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        g.setColor(Color.black);
        g.fillRect(0, 0, 100, 20);
        int fsize = (int) (20 * 0.8);//字体大小为图片高度的80%
        int fx = 0;
        int fy = fsize;
        g.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, fsize));
        g.setColor(Color.white);
        //写字符
        for (int i = 0; i < stringBuffer.length(); i++) {
            g.drawString(stringBuffer.charAt(i) + "", fx, fy);
            fx += (20 / (stringBuffer.length() + 1)) + 5;
        }
        g.dispose();
        ImageIO.write(image, "jpg", resp.getOutputStream());
        req.getSession().setAttribute("code", stringBuffer);        ;

    }

    /**
     * 生成验证码
     *
     * @param length 验证码长度
     * @return 返回生成的验证码
     */
    private String createCode(int length) {
        String a = "";
        while (a.length() < length) {
            a += (identityString.charAt((int) (Math.random() * 62)));
        }
        return a;
    }
}

