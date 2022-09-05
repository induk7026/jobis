package com.project.jobis.security.oauth2.controller;

import com.project.jobis.response.CommonResponse;
import com.project.jobis.security.CurrentUser;
import com.project.jobis.security.TokenProvider;
import com.project.jobis.security.UserPrincipal;
import com.project.jobis.user.controller.dto.UserLoginRequest;
import com.project.jobis.user.controller.dto.UserResponse;
import com.project.jobis.user.controller.dto.UserSignupRequest;
import com.project.jobis.user.domain.User;
import com.project.jobis.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/szs")
public class AuthController {

    private final TokenProvider tokenProvider;
    private final UserService userService;

    @PostMapping("/signup")
    public CommonResponse signupUser(@RequestBody UserSignupRequest userSignupRequest){
        User user = userService.signupUser(userSignupRequest);
        return CommonResponse.success(UserResponse.toEntity(user));
    }

    @PostMapping("/login")
    public CommonResponse loginUser(@RequestBody UserLoginRequest userSignupRequest){
        var user = userService.authenticateByEmailAndPassword(userSignupRequest);
        userService.updateLastLoginAt(user);
        var token = tokenProvider.createToken(user.getId());
        return CommonResponse.success(token);
    }

    @GetMapping("/me")
    public CommonResponse userInfo(@CurrentUser UserPrincipal userPrincipal){
        return CommonResponse.success(userService.findUserById(userPrincipal.getId()));
    }
}
