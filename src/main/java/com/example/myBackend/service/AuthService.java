package com.example.myBackend.service;

import com.example.myBackend.dto.*;
import com.example.myBackend.model.User;
import com.example.myBackend.repository.UserRepository;
import com.example.myBackend.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthService {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public LoginResponse login(LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail(),
                        loginRequest.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = tokenProvider.generateToken(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        UserAuthDto userDto = new UserAuthDto(userDetails.getUsername(), userDetails.getPassword());
        return LoginResponse.builder()
                .token(jwt)
                .user(userDto)
                .build();
    }
@Transactional
    public SignUpResponse signUp(SignUpRequest signUpRequest) {
        User newUser = new User();
        newUser.setUsername(signUpRequest.getUsername());
        newUser.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
        newUser.setEmail(signUpRequest.getEmail());
        userRepository.save(newUser);
        SignUpResponse signUpResponse = new SignUpResponse();
        signUpResponse.setUsername(newUser.getUsername());
        return signUpResponse;
    }
}