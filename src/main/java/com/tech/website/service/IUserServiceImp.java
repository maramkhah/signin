package com.tech.website.service;

import java.util.List;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tech.website.Exception.UserNotFoundException;
import com.tech.website.pojo.User;
import com.tech.website.repository.UserRepository;

@Service
public class IUserServiceImp implements IUserService{
    @Autowired
    private UserRepository repository;

    @Override
    public User getUserById(String id) {
        return repository.getUser(findIndexByID(id));
    }

    @Override
    public void saveUser(User user) {
        repository.saveUser(user);
    }

    @Override
    public List<User> getUsers() {
        return repository.getUsers();
    }


    @Override
    public void deleteUser(String id) {
        repository.deleteUser(findIndexByID(id));
    }

    private int findIndexByID(String id){
        return IntStream.range(0, repository.getUsers().size())
        .filter(index->repository.getUsers().get(index).getId().equals(id))
        .findFirst()
        .orElseThrow(()->new UserNotFoundException(id));
    }
    
}
