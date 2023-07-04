package com.project.db.mju.webserver.web.v2.service;

import com.project.db.mju.webserver.web.v1.domain.Employee;
import com.project.db.mju.webserver.web.v1.dto.LoginRequestDto;
import com.project.db.mju.webserver.web.v1.dto.LoginResponseDto;
import com.project.db.mju.webserver.web.v1.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "v2LoginService")
public class LoginService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public LoginResponseDto loginAuth(LoginRequestDto requestDto) {

        Employee result = employeeRepository.findEmployeeByUserId(requestDto.getUserId());

        if (result.getUserPw().equals(requestDto.getUserPw())) {
            return new LoginResponseDto(result.getName());
        }
        else {
            return null;
        }
    }
}
