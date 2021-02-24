package com.example.mvcdemo.service;

import com.example.mvcdemo.model.User;
import org.dom4j.DocumentException;

import java.io.IOException;

public interface ServiceBussiness {
    void register(User user) throws IOException, DocumentException;
    void login(String username, String password);
}
