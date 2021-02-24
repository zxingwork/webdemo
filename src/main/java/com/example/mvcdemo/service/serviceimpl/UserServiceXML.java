package com.example.mvcdemo.service.serviceimpl;

import com.example.mvcdemo.dao.UserDao;
import com.example.mvcdemo.dao.daoimpl.UserImplXML;
import com.example.mvcdemo.model.User;
import com.example.mvcdemo.service.ServiceBussiness;
import org.dom4j.DocumentException;

import java.io.IOException;

public class UserServiceXML implements ServiceBussiness {
    UserDao userImplXML = new UserImplXML();
    @Override
    public void register(User user) throws IOException, DocumentException {
        userImplXML.register(user);
    }

    @Override
    public void login(String username, String password) {
        userImplXML.find(username, password);
    }
}
