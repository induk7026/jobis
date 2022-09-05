package com.project.jobis.user.controller.dto;

import lombok.Data;

@Data
public class UserSignupRequest {

    private String userId;
    private String password;
    private String regNo;
    private String name;
}
