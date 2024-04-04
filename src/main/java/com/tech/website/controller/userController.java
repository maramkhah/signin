package com.tech.website.controller;

import com.tech.website.pojo.User;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class userController {

    List<User> userList = new ArrayList<>(); 
    
    @GetMapping("/")
    public String getindex(Model model,@RequestParam(required = false)String id){
        int index = getUserIndex(id);
        model.addAttribute("user", index ==Constants.NOT_FOUND ? new User():userList.get(index));
        return "index";
    }

    @GetMapping("/users")
    public String getusers(Model model){
        model.addAttribute("users", userList);
        return "users";
    }
    

    @PostMapping("/handleSubmit")
    public String submitForm(User user){
        System.out.println(user);
        userList.add(user);
        return "redirect:/users";
    }

    public int getUserIndex (String id){
        for(int i=0; i<userList.size();i++){
            if(userList.get(i).getId().equals(id))return i;
        }
        return Constants.NOT_FOUND;
    }

}
