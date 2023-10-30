package com.example.myproject.service;

import com.example.myproject.model.User;
import com.example.myproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddUserService {

    @Autowired
    private UserRepository userRepository;

    public String addUser(User user){
        userRepository.save(user);
        return "user is created";

    }
}
