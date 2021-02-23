package com.example.webdemo;


import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Enumeration;
import java.util.List;

@WebServlet(name = "UploadServlet", urlPatterns = "/UploadServlet")
public class UploadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Enumeration<String> names = req.getAttributeNames();
//        while (names.hasMoreElements()){
//            System.out.println("attribute: "+names.nextElement());
//        }
//
//        ServletInputStream inputStream = req.getInputStream();
//        byte[] bytes = new byte[1024];
//        int len = 0;
//        while ((len=inputStream.read(bytes))>0){
//            System.out.println("in in");
//            System.out.println(new String(bytes, 0, len));
//        }
        try {
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);

            if (!ServletFileUpload.isMultipartContent(req)){
                System.out.println("return");
                return;
            }
            List<FileItem> list = upload.parseRequest(req);

            for (FileItem item : list) {
                if (item.isFormField()){
                    String name = item.getFieldName();
                    String value = item.getString();
                    System.out.println(name+"="+value);
                }else {
                    String filename = item.getFieldName();

                    System.out.println(filename);
                    filename = filename.substring(filename.lastIndexOf("\\")+1);
                    System.out.println("filename:"+filename);
                    InputStream in = item.getInputStream();
                    int len = 0;
                    byte[] buffer = new byte[1024];
                    String savepath = this.getServletContext().getRealPath("/upload");
                    System.out.println("path:"+savepath+"/"+filename);
                    File folder = new File(savepath);
                    if (!folder.exists()||!folder.isDirectory()){
                        folder.mkdirs();
                        System.out.println("创建文件夹");
                    }else System.out.println("文件夹存在");
                    FileOutputStream out = new FileOutputStream(savepath+"/"+filename);
                    while ((len=in.read(buffer))>0){

                        out.write(buffer,0,len);
                    }
                    in.close();
                    out.close();
                    String rs = "上传成功！";
                    resp.setContentType("text/html;charset=UTF-8");
                    PrintWriter printWriter = resp.getWriter();
                    printWriter.write(rs);
                }
            }

        } catch (FileUploadException e) {
            e.printStackTrace();
        }

    }
}
