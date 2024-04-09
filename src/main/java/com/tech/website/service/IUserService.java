package com.tech.website.service;
import java.util.List;

import com.tech.website.pojo.User;

public interface IUserService{
    //crud
    User getUserById(String id);
    void saveUser(User user);
    List<User> getUsers();
    void deleteUser(String id);

}