package com.tech.website.controller;

import com.tech.website.pojo.User;
import com.tech.website.service.IUserServiceImp;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {


    @Autowired
    private IUserServiceImp serviceImp;
    
    @GetMapping(value = "/users")
    public ResponseEntity<List<User>> getUsers(){
    List<User> users = serviceImp.getUsers();
    return new ResponseEntity<>(users,HttpStatus.OK);
    }

    @GetMapping(value = "/users/{id}")
    public ResponseEntity<User> getUser(@PathVariable String id){
        User user = serviceImp.getUserById(id);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }


    @PostMapping(value = "/user")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){
        serviceImp.saveUser(user);
        return new ResponseEntity<>(user,HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/delete/{id}/users")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable String id){
        serviceImp.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
