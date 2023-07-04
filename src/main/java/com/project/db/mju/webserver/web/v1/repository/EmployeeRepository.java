package com.project.db.mju.webserver.web.v1.repository;

import com.project.db.mju.webserver.web.v1.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    public Employee findEmployeeByUserId(String userId);
    public Employee findEmployeeByName(String name);
}
