package com.example.webdemo;

import java.util.List;

public class UserDao {
    public User find(String username, String password){
        List<User> userList = UserDB.getUsers();
        for (User user : userList) {
            if (user.getUsername().equals(username)&&user.getPassword().equals(password)){
                return user;
            }
        }
        return null;
    }
}
