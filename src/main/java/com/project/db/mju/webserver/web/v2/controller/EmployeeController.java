package com.project.db.mju.webserver.web.v2.controller;

import com.project.db.mju.webserver.web.v1.domain.Employee;
import com.project.db.mju.webserver.web.v2.dto.EmployeeDto;
import com.project.db.mju.webserver.web.v2.service.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v2")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employees")
    @ApiOperation(value = "모든 사원들을 가져온다")
    public List<EmployeeDto> employees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employees/{employeeName}")
    @ApiOperation(value = "특정 사원의 정보를 가져온다")
    public EmployeeDto getEmployee(@PathVariable(value = "employeeName") String employeeName) {
        return employeeService.getEmployee(employeeName);
    }
}
