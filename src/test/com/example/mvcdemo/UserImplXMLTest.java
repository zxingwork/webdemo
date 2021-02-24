package com.example.mvcdemo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
}