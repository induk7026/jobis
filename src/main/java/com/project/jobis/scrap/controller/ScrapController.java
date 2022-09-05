package com.project.jobis.scrap.controller;

import com.project.jobis.scrap.controller.dto.ScrapRequest;
import com.project.jobis.scrap.controller.response.ScrapResponse;
import com.project.jobis.scrap.service.ScrapService;
import com.project.jobis.security.CurrentUser;
import com.project.jobis.security.UserPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ScrapController {

    private final ScrapService scrapService;

    @PostMapping("/szs/scrap")
    public ScrapResponse signupUser(@CurrentUser UserPrincipal userPrincipal,
        @RequestBody ScrapRequest scrapRequest){
        return ScrapResponse.success(scrapService.findAll(scrapRequest, userPrincipal.getId()));
    }
}
