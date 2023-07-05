package com.project.db.mju.webserver.web.v1.repository;

import com.project.db.mju.webserver.web.v1.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    public Employee findEmployeeByUserId(String userId);
    public Employee findEmployeeByName(String name);

    public Optional<Employee> findByName(String name);

    public Optional<Employee> findByUserId(String userid);
}
