package com.project.db.mju.webserver.web.v2.service.impl;

import com.project.db.mju.webserver.web.v1.domain.Employee;
import com.project.db.mju.webserver.web.v1.dto.LoginRequestDto;
import com.project.db.mju.webserver.web.v1.dto.LoginResponseDto;
import com.project.db.mju.webserver.web.v1.repository.EmployeeRepository;
import com.project.db.mju.webserver.web.v2.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "v2LoginService")
public class LoginServiceImpl implements LoginService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public LoginServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public LoginResponseDto loginAuth(LoginRequestDto requestDto) {

        Employee result = employeeRepository.findByUserId(requestDto.getUserId())
                .orElseThrow(() -> new RuntimeException());
        if (result.getUserPw().equals(requestDto.getUserPw())) return new LoginResponseDto(result.getName());
        else throw new RuntimeException();
    }
}
