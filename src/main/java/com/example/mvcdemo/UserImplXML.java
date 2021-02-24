package com.example.mvcdemo;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class UserImplXML {
    public User find(String username, String password){
//        InputStream inputStream = UserImplXML.class.getClassLoader().getResourceAsStream("user.xml");

        SAXReader saxReader = new SAXReader();
        String path = "user.xml";

        try {
            Document document = saxReader.read(new File(path));
            Element rootElement = document.getRootElement();
            Iterator iterator = rootElement.elementIterator();

            while (iterator.hasNext()){
                Element stu = (Element) iterator.next();
                List<Attribute> attributes = stu.attributes();
                System.out.println("======获取属性值======");
                for (Attribute attribute:attributes){
                    System.out.println(attribute.getValue());
                }
                System.out.println("======遍历子节点======");
                Iterator iterator1 = stu.elementIterator();
                while (iterator1.hasNext()){
                    Element stuChild = (Element) iterator1.next();
                    System.out.println("节点名："+stuChild.getName()+"---节点值："+stuChild.getStringValue());
                }
            }
            Element element = (Element) document.selectSingleNode("user");
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
}
