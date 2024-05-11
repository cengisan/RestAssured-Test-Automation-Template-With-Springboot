package com.springboot.automation.model.response.auth;

import lombok.Data;

@Data
public class RefreshAuthSessionResponse {

    private int id;
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private String gender;
    private String image;
    private String token;

}
