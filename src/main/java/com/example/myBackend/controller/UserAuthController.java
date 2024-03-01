package com.example.myBackend.controller;

import com.example.myBackend.dto.LoginRequest;
import com.example.myBackend.dto.LoginResponse;
import com.example.myBackend.dto.SignUpRequest;
import com.example.myBackend.dto.SignUpResponse;
import com.example.myBackend.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class UserAuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/api/signIn")
    public LoginResponse login(@RequestBody LoginRequest loginRequest) {
        LoginResponse loginResponse = authService.login(loginRequest);
        return loginResponse;
        //return ResponseEntity.ok(authService.login(loginRequest));
    }

    @PostMapping("/api/signUp")
    public SignUpResponse signUp(@RequestBody SignUpRequest signUpRequest) {
        return authService.signUp(signUpRequest);
    }
}