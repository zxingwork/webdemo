package com.example.mvcdemo.dao.daoimpl;

import com.example.mvcdemo.dao.UserDao;
import com.example.mvcdemo.model.User;
import org.dom4j.*;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserImplXML implements UserDao {
    String path = UserImplXML.class.getClassLoader().getResource("user.xml").getPath();
//    String path = "/src/main/webapp/user.xml";
    @Override
    public User find(String username, String password){
//        InputStream inputStream = UserImplXML.class.getClassLoader().getResourceAsStream("user.xml");

        SAXReader saxReader = new SAXReader();


        try {
            Document document = saxReader.read(path);

//            Element element = (Element) document.getRootElement();
            String xpath = "/users/user[@username='zhangxing' and @password='1234']";
            Element element = (Element) document.selectSingleNode(xpath);
            if (element==null){
                System.out.println("element is null");
                return null;
            }
            User user = new User();
            user.setId(element.attributeValue("id"));
            user.setUsername(element.attributeValue("username"));
            user.setPassword(element.attributeValue("password"));
            user.setEmail(element.attributeValue("email"));

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
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

    @Override
    public void register(User user) throws DocumentException, IOException {
        SAXReader saxReader = new SAXReader();
        System.out.println(path);
        Document document = saxReader.read(path);

        Element newElement = DocumentHelper.createElement("user");
        newElement.addAttribute("id", String.valueOf(user.getId()));
        newElement.addAttribute("username", user.getUsername());
        newElement.addAttribute("password", user.getPassword());
        newElement.addAttribute("email", user.getEmail());

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String birthday = simpleDateFormat.format(user.getBirthday());
        System.out.println(birthday);
        newElement.addAttribute("birthday", birthday);
        document.getRootElement().add(newElement);

        OutputFormat outputFormat = OutputFormat.createPrettyPrint();
        outputFormat.setEncoding("UTF-8");
        XMLWriter xmlWriter = new XMLWriter(new FileWriter(path), outputFormat);
        xmlWriter.write(document);
        xmlWriter.close();
    }
}
