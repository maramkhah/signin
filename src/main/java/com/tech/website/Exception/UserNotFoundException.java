package com.tech.website.Exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String id){
        super("The id "+id+"Does not exist in our records.");
    }
    
}
