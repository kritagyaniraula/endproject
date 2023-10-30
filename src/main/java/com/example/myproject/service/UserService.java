package com.example.myproject.service;

import com.example.myproject.config.UserInfoDetails;
import com.example.myproject.model.User;
import com.example.myproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUserName(username);
        return user.map(UserInfoDetails::new)
                .orElseThrow(()->new UsernameNotFoundException("user not found"));
    }
}
