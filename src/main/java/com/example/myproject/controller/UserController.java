package com.example.myproject.controller;

import com.example.myproject.model.User;
import com.example.myproject.service.AddUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private AddUserService addUserService;

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to the dashboard";
    }


    @PostMapping("/register")
    public String addUser(@RequestBody User user)
    {
        return addUserService.addUser(user);
    }


}
