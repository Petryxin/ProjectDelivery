package com.exposit.service;

import com.exposit.models.User;


public class UserService {
    public User userRegistrationInDelivery(String login,String email, String password, String name,
                                           String address, long phoneNumber){
        User user = new User(login, email, password,name, address, phoneNumber);
        return user;
    }

    public User changeUserEmail(User user, String email){
        user.setEmail(email);
        return user;
    }
    public User deleteUserEmail(User user){
        user.setEmail(null);
        return user;
    }

    public User changeUserLogin(User user, String login){
        user.setLogin(login);
        return user;
    }

    public User deleteUserLogin(User user){
        user.setLogin(null);
        return user;
    }

    public User changeUserPassword(User user, String password){
        user.setPassword(password);
        return user;
    }

    public User deleteUserPassword(User user){
        user.setPassword(null);
        return user;
    }

    public User changeUserAddress(User user, String address){
        user.setUserAddress(address);
        return user;
    }
    public User deleteUserAddress(User user){
        user.setUserAddress(null);
        return user;
    }

    public User changeUserName(User user, String name){
        user.setUserName(name);
        return user;
    }

    public User deleteUserName(User user){
        user.setUserName(null);
        return user;
    }

    public User changePhoneNumber(User user, long phoneNumber){
        user.setPhoneNumber(phoneNumber);
        return user;
    }

    public User deletePhoneNumber(User user){
        user.setPhoneNumber(0);
        return user;
    }
}
