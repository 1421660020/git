package com.web.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author Administrator
 * @Date 2021/11/28 17:22
 * @Version 1.0
 */

public class UpLoad extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*  insertBook(request, response);*/
    }

  /*  protected void insertBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (ServletFileUpload.isMultipartContent(request)) {
            //表单项类
            FileItemFactory fileItemFactory = new DiskFileItemFactory();
            //表单项处理类
            ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);
            try {
                List<FileItem> list = servletFileUpload.parseRequest(request);
                Book book = new Book();
                book.setName(list.get(0).getFieldName());
                book.setPrice(new BigDecimal(list.get(1).getFieldName()));
                book.setSales(Integer.parseInt(list.get(2).getFieldName()));
                book.setStock(Integer.parseInt(list.get(3).getFieldName()));
                FileItem f = list.get(4);
                String fileName = new String(f.getName().getBytes("gbk"), "UTF-8");
                File file = new File("D:\\ideaProject\\test1\\out\\artifacts\\Shop_war_exploded\\static\\img\\" + fileName);
                f.write(file);
                book.setimgpath("/static/img/" + fileName);
                //普通表单项
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }
*/

//    public void uploadImg(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        if (ServletFileUpload.isMultipartContent(request)) {
//            //表单项类
//            FileItemFactory fileItemFactory = new DiskFileItemFactory();
//            //表单项处理类
//            ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);
//            try {
//                List<FileItem> list = servletFileUpload.parseRequest(request);
//                for (FileItem fileItem : list) {
//                    if (fileItem.isFormField()) {
//                        //普通表单项
//                        System.out.println("表单项的name属性值: " + fileItem.getFieldName());
//                        System.out.println("表单项的value属性值: " + fileItem.getString("utf-8"));
//                    } else {
//                        System.out.println("表单项的name属性值: " + fileItem.getFieldName());
//                        String fileName = new String(fileItem.getName().getBytes("gbk"), "UTF-8");
//                        System.out.println("上传的文件名: " + fileName);
//                        fileItem.write(new File("C:\\Users\\Administrator\\Desktop\\" + fileName));
//                    }
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//    }
}
