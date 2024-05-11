package com.springboot.automation.model.request.auth;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class AuthRequest {
    private String username;
    private String password;
    private int expiresInMins;
}
