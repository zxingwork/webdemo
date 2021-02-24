package com.example.mvcdemo.dao;

import com.example.mvcdemo.model.User;
import org.dom4j.DocumentException;

import java.io.IOException;

public interface UserDao {
    User find(String username, String password);

    void register(User user) throws DocumentException, IOException;
}
