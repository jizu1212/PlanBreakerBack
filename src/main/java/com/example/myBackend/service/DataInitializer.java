package com.example.myBackend.service;

import com.example.myBackend.model.User;
import com.example.myBackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;
import org.springframework.transaction.annotation.Transactional;

@Component
public class DataInitializer {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    @Transactional
    public void init() {
        userRepository.save(new User("goodman", passwordEncoder.encode("123456")));
        userRepository.save(new User("badman", passwordEncoder.encode("654321")));
    }
}