package com.project.db.mju.webserver.web.v2.controller;

import com.project.db.mju.webserver.web.v1.dto.LoginRequestDto;
import com.project.db.mju.webserver.web.v1.dto.LoginResponseDto;
import com.project.db.mju.webserver.web.v2.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v2")
@RestController(value = "v2LoginController")
public class LoginController {

    @Autowired
    LoginService loginService;

    @PostMapping("/login")
    public LoginResponseDto login(@RequestBody LoginRequestDto requestDto) {
        LoginResponseDto loginResponseDto = loginService.loginAuth(requestDto);
        return loginResponseDto;
    }
}
