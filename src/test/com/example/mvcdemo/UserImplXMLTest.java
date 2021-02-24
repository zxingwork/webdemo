package com.example.mvcdemo;

import com.example.mvcdemo.dao.daoimpl.UserImplXML;
import com.example.mvcdemo.model.User;
import org.dom4j.DocumentException;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Date;

class UserImplXMLTest {
    private String username = "zhongfucheng";
    private String password = "123";
    @Test
    void find() {
        UserImplXML userImplXML = new UserImplXML();
        User user = userImplXML.find(username, password);
        System.out.println(user);

        System.out.println("birthday:"+user.getBirthday());
        System.out.println("email:"+user.getEmail());
        System.out.println("id:"+user.getId());
        System.out.println("username:"+user.getUsername());
        System.out.println("password:"+user.getPassword());
    }

    @Test
    void register() throws IOException, DocumentException {
        UserImplXML userImplXML = new UserImplXML();
        User user = new User("edsds", "zx3", "122", "zx@163.com", new Date());
        userImplXML.register(user);
    }
}