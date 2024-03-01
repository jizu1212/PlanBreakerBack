package com.example.myBackend.dto;

import com.example.myBackend.model.UserDescription;
import lombok.Data;

@Data
public class UserBusinessDto {
    private String username;
    private String email;
    private String rewards;
    private UserDescription description;

    public UserBusinessDto() {
    }

}