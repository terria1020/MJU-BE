package com.project.db.mju.webserver.web.v2.service;

import com.project.db.mju.webserver.web.v1.domain.Employee;
import com.project.db.mju.webserver.web.v1.repository.EmployeeRepository;
import com.project.db.mju.webserver.web.v2.dto.EmployeeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service(value = "v2EmployeeService")
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee getByName(String name) {
        return employeeRepository.findEmployeeByName(name);
    }

    public Employee getById(Long id) {
        return employeeRepository.findById(id).get();
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
