package com.project.db.mju.webserver.web.v2.service;

import com.project.db.mju.webserver.web.v2.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    public List<EmployeeDto> getAllEmployees();
    public EmployeeDto getEmployee(String name);
}
