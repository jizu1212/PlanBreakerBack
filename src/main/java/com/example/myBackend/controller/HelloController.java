package com.example.myBackend.controller;

import com.example.myBackend.model.User;
import com.example.myBackend.model.UserDescription;
import com.example.myBackend.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {
    @Autowired
    private AuthService authService;

    @GetMapping("/hello")
    public String hello() {
        return "Hello!";
    }

    @GetMapping("/sampleUserInfo")
    public User sampleUserInfo() {
        UserDescription description = new UserDescription("my description");
        User user = new User("jisoo","1234","my reward",description);
        return user;
    }
    @PostMapping("/test-request")
    public ResponseEntity<String> testPostRequest() {
        return ResponseEntity.ok("POST request successful");
    }

}