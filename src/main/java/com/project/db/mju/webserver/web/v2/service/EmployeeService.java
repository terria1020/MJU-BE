package com.project.db.mju.webserver.web.v2.service;

import com.project.db.mju.webserver.web.v1.domain.Employee;
import com.project.db.mju.webserver.web.v1.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "v2EmployeeService")
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee getByName(String name) {
        return employeeRepository.findEmployeeByName(name);
    }

    public Employee getById(Long id) {
        return employeeRepository.findById(id).get();
    }
}
