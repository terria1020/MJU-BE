package com.project.db.mju.webserver.web.v1.service;

import com.project.db.mju.webserver.web.v1.domain.Employee;
import com.project.db.mju.webserver.web.v1.domain.Project;
import com.project.db.mju.webserver.web.v1.domain.ProjectDetail;
import com.project.db.mju.webserver.web.v1.dto.ProjectDetailViewResponseDto;
import com.project.db.mju.webserver.web.v1.repository.EmployeeRepository;
import com.project.db.mju.webserver.web.v1.repository.JobRepository;
import com.project.db.mju.webserver.web.v1.repository.ProjectDetailRepository;
import com.project.db.mju.webserver.web.v1.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectDetailService {

    @Autowired
    ProjectDetailRepository detailRepository;

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    JobRepository jobRepository;
    public List<ProjectDetailViewResponseDto> getAllDetails(Long projectId) {
        List<ProjectDetail> details = detailRepository.findAllProjectDetailRepositoryByProjectId(projectId);

        List<ProjectDetailViewResponseDto> viewResponseDtos = new ArrayList<>();

        for (ProjectDetail detail: details) {
            Optional<Project> proj = projectRepository.findById(detail.getProjectId());
            Optional<Employee> employee = employeeRepository.findById(detail.getEmployeeNumber());

            viewResponseDtos.add(new ProjectDetailViewResponseDto(
                    employee.get().getName(),
                    jobRepository.findById(detail.getEmployeeJob()).get().getType(),
                    detail.getJoinDate(),
                    detail.getQuitDate()
            ));
        }

        return viewResponseDtos;
    }
}
