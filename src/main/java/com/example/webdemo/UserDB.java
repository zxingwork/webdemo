package com.example.webdemo;

import java.util.ArrayList;
import java.util.List;

public class UserDB {
    private static List<User> users = new ArrayList<>();


    //静态代码域，在类的加载的时候调用一次，整个生命周期只会调用一次。
    static {
        users.add(new User("aaa", "123"));
        users.add(new User("bbb", "123"));
        users.add(new User("ccc", "123"));
    }

    public static List<User> getUsers() {
        return users;
    }

    public static void setUsers(List<User> users) {
        UserDB.users = users;
    }
}
