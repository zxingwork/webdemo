package com.example.mvcdemo;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserImplXML {
    public User find(String username, String password){
        InputStream inputStream = UserImplXML.class.getClassLoader().getResourceAsStream("user.xml");

        SAXReader saxReader = new SAXReader();
        String path = "user.xml";

        try {
            Document document = saxReader.read(path);
            Element element = (Element) document.selectSingleNode("//user[@username='"+username+"'and@password='"+password+"']");
            if (element==null){
                return null;
            }
            User user = new User();
            user.setId(Integer.parseInt(element.attributeValue("id")));
            user.setUsername(element.attributeValue("username"));
            user.setPassword(element.attributeValue("password"));
            user.setEmail(element.attributeValue("email"));

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd");
            Date birthday = simpleDateFormat.parse(element.attributeValue("birthday"));
            user.setBirthday(birthday);
            return user;

        } catch (DocumentException e) {
            e.printStackTrace();
            throw new RuntimeException("初始化出错");
        }catch (ParseException e){
            e.printStackTrace();
            throw new RuntimeException("查询时出错");
        }
    }
    private String username = "zhongfucheng";
    private String password = "123";



}