package com.project.jobis.refund.controller;

import com.project.jobis.response.CommonResponse;
import com.project.jobis.security.CurrentUser;
import com.project.jobis.security.UserPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RefundController {


    @GetMapping("/szs/refund")
    public CommonResponse refund(@CurrentUser UserPrincipal userPrincipal){
        return CommonResponse.success("");
    }
}
