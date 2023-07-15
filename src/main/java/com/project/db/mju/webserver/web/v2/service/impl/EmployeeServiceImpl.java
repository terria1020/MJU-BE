package com.project.db.mju.webserver.web.v2.service.impl;

import com.project.db.mju.webserver.web.v1.repository.EmployeeRepository;
import com.project.db.mju.webserver.web.v2.dto.EmployeeDto;
import com.project.db.mju.webserver.web.v2.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service(value = "v2EmployeeService")
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<EmployeeDto> getAllEmployees() {
        return employeeRepository.findAll()
                .stream()
                .map(EmployeeDto::of)
                .collect(Collectors.toList());
    }

    public EmployeeDto getEmployee(String name) {
        return EmployeeDto.of(employeeRepository.findEmployeeByName(name));
    }
}
