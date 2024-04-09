package com.tech.website.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.tech.website.pojo.User;

@Repository
public class UserRepository {
    List<User> users = new ArrayList<>();

    //CRUD

    public List<User> getUsers(){
        return users;
    }
    
    public User getUser(int index){
        return users.get(index);
    }

    public void saveUser(User user){
        users.add(user);
    }

    public void deleteUser(int index){
        users.remove(index);
    }
}
