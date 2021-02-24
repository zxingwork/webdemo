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

        System.out.println(user.getBirthday());
        System.out.println(user.getEmail());
        System.out.println(user.getId());
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
    }
}