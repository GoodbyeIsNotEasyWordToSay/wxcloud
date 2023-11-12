package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class LoginController {

    final LoginService loginService;

    public LoginController(@Autowired LoginService loginService){
        this.loginService = loginService;
    }

    @GetMapping(value = "/api/login/{openID}")
    public ApiResponse getDetails(@PathVariable String openID) {
        Optional<Integer> UID = loginService.getUID(openID);
        return ApiResponse.ok(UID);
    }
}
