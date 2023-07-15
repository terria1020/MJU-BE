package com.project.db.mju.webserver.web.v2.service;

import com.project.db.mju.webserver.web.v1.dto.LoginRequestDto;
import com.project.db.mju.webserver.web.v1.dto.LoginResponseDto;

public interface LoginService {
    public LoginResponseDto loginAuth(LoginRequestDto requestDto);
}
