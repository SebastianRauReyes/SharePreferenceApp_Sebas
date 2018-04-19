package com.rau.sebastian.sharepreferenceapp_sebas.repository;

import com.rau.sebastian.sharepreferenceapp_sebas.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    public static List<User> users = new ArrayList<>();

    static{
        users.add(new User(100, "sebas", "tecsup", "Sebastian Rau"));
        users.add(new User(200, "ale", "tecsup", "Pequeña comita"));
        users.add(new User(300, "drodriguez", "tecsup", "David Rodriguez"));
    }

    public static User login(String username, String password){
        for (User user : users){
            if(user.getUsername().equalsIgnoreCase(username) && user.getPassword().equals(password)){
                return user;
            }
        }
        return null;
    }

    public static User getUser(String username){
        for (User user : users){
            if(user.getUsername().equalsIgnoreCase(username)){
                return user;
            }
        }
        return null;
    }




}
