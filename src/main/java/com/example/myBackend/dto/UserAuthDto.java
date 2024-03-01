package com.example.myBackend.dto;

import lombok.Data;

@Data
public class UserAuthDto {
    private String username;
    private String password;
    private String email;

    public UserAuthDto() {
    }
    //constructor for email and password
    public UserAuthDto(String email, String password) {
        this.email = email;
        this.password = password;
    }

}